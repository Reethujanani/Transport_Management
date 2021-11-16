package com.example.transport.service;

import com.example.transport.dto.TokenDTO;
import com.example.transport.dto.UserDTO;
import com.example.transport.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.security.core.userdetails.UserDetails;

public interface UserService {

    UserDTO addUser(UserDTO user);

    Page<User> listAllDetails(int pageNo , int pageSize, String sortBy);

    User getProductDetailsByID(int id);

    UserDTO updateProductDetails(UserDTO product);

    String deleteDetailsById(int id);

    String login(TokenDTO tokenDTO);

    UserDetails loadByUserName(String userName);
}
