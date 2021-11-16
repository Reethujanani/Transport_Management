package com.example.transport.service.ServiceImpl;

import ch.qos.logback.classic.Logger;
import com.example.transport.dto.TokenDTO;
import com.example.transport.dto.UserDTO;
import com.example.transport.entity.Role;
import com.example.transport.entity.User;
import com.example.transport.entity.UserRole;
import com.example.transport.exception.UnAuthException;
import com.example.transport.repository.RoleRepository;
import com.example.transport.repository.UserRepository;
import com.example.transport.TransportMgmtApplication;
import com.example.transport.service.SleuthService;
import com.example.transport.service.UserService;
import com.example.transport.util.JwtUtil;
import javassist.bytecode.stackmap.Tracer;
import org.modelmapper.ModelMapper;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.*;

@Service
public class UserServiceImpl<Span, SpanInScope> implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    JwtUtil jwtUtil = new JwtUtil();

    private static final Logger LOGGER= (Logger) LoggerFactory.getLogger(TransportMgmtApplication.class);

    @Override
    public UserDTO addUser(UserDTO user) {

        ModelMapper modelMapper = new ModelMapper();
        User user1 = modelMapper.map(user,User.class);
        List<UserRole> roleList = new LinkedList<>();
        user.getRoleList().stream().forEachOrdered(action->{
            UserRole userRole = new UserRole();
            Optional<Role> role = roleRepository.findById(action.getId());
            userRole.setRole(role.get());
            userRole.setUser(user1);
            roleList.add(userRole);
        });
        Optional<User> userCheck = userRepository.findByUserName(user.getUserName());
        if(userCheck.isPresent()){
            LOGGER.info("Username Already available");
            throw new UnAuthException("Already available");
        }
        user1.setUserRoles(roleList);
        try {
            userRepository.save(user1);
            LOGGER.info("user saved successfully");

        } catch (Exception e) {
            LOGGER.info("Error while saving user");
        }
        return user;
    }

    @Override
    public Page<User> listAllDetails(int pageNo , int pageSize, String sortBy) {
        try {
            Pageable pageable = PageRequest.of(pageNo, pageSize, Sort.by(Sort.Direction.DESC, sortBy));
            Page<User> users = userRepository.findAll(pageable);
            LOGGER.info("user saved successfully");
            return users;
        }
        catch(Exception e){
            e.getMessage();
        }
        return null;
    }

    @Override
    public UserDTO updateProductDetails(UserDTO user) {
        User user1 = new User();
        user1.setId(user.getId());
        user1.setUserName(user.getUserName());
        user1.setPassword(user.getPassword());
        user1.setMobileNo(user.getMobileNo());
        user1.setIsActive(user.getIsActive());
        user1.setIsDeleted(user.getIsDeleted());
        userRepository.save(user1);
        LOGGER.info("user updated successfully");
        return null;
    }
    public User getProductDetailsByID(int userid) {
        Optional<User> user = userRepository.findById(userid);
        return user.get();
    }
        @Override
    public String deleteDetailsById(int id) {
        try {
            userRepository.deleteById(id);
            LOGGER.info("user deleted successfully");
            return "successfully deleted";
        }
        catch (Exception e){
            e.getMessage();
        }
            return null;
    }

    @Override
    public String login(TokenDTO tokenDTO) {
        Optional<User> Obj = userRepository.findByUserNameAndPassword(tokenDTO.getUsername(),tokenDTO.getPassword());
        String token= "";
        try
        {
            if(Obj.isPresent())
            {
                List<Role> roles = new LinkedList<>();
                Obj.get().getUserRoles().stream().forEachOrdered(role->{
                    Role newRole = new Role();
                    newRole.setRoleName(role.getRole().getRoleName());
                    newRole.setId(role.getId());
                    roles.add(newRole);
                });
              token = JwtUtil.generateToken("Jwt_Token",Obj.get().getId(),roles,Obj.get().getUserName());
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return token;
    }

    @Override
    public UserDetails loadByUserName(String userName) {
        try {
            Optional<User> user = userRepository.findByUserName(userName);
            Set authority = authority(userName);

            return new org.springframework.security.core.userdetails.User(user.get().getUserName(), user.get().getPassword(), authority);
        }
        catch(Exception e){
            e.getMessage();
        }
        return null;
    }
    public Set authority(String userName){
        try {
            Optional<User> user = userRepository.findByUserName(userName);
            Set authority = new HashSet();
            user.get().getUserRoles().stream().forEachOrdered(action -> {
                authority.add(new SimpleGrantedAuthority("ROLE_" + action.getRole().getRoleName()));
            });

            return authority;
        }
        catch (Exception e){
            e.getMessage();
        }
            return null;
    }

}




