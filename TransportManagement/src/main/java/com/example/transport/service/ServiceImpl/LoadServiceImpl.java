package com.example.transport.service.ServiceImpl;

import com.example.transport.dto.LoadDTO;
import com.example.transport.dto.UserDTO;
import com.example.transport.dto.VehicleDTO;
import com.example.transport.entity.*;
import com.example.transport.repository.LoadRepository;
import com.example.transport.repository.VehicleRepository;
import com.example.transport.repository.UserRepository;
import com.example.transport.service.LoadService;
import com.sun.istack.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Service

public class LoadServiceImpl implements LoadService {
    private static final Logger LOGGER = null;

    @Autowired
    private LoadRepository loadRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private VehicleRepository vehicleRepository;
    @Override
    public LoadDTO addLoad(LoadDTO loadDTO) {
        Load load = new Load();
        try {
        Optional<User> user = userRepository.findById(loadDTO.getUserid());
        load.setId(load.getId());
        load.setUser(user.get());
        load.setLoadName(load.getLoadName());
        load.setSourceFrom(load.getSourceFrom());
        load.setToDestination(load.getToDestination());
        load.setIsActive(load.getIsActive());
        load.setIsDeleted(load.getIsDeleted());
        List<VehicleLoad> vehicleLoads = new LinkedList<>();
        loadDTO.getVehicleDTOList().stream().forEachOrdered(action->{
            VehicleLoad vehicleLoad = new VehicleLoad();
            Optional<Vehicles> vehicle = vehicleRepository.findById(action.getId());
            vehicleLoad.setVehicle(vehicle.get());
            vehicleLoad.setLoad(load);
            vehicleLoads.add(vehicleLoad);
        });


            load.setVehicleLoadList(vehicleLoads);
            loadRepository.save(load);
        }catch (Exception e){
            e.getMessage();
        }
        return loadDTO;
    }

    @Override
    public LoadDTO addOrder(LoadDTO order) {
        return null;
    }


    @Override
    public Page<Load> listAllDetails(int pageNo, int pageSize, String sortBy) {
        Pageable pageable = PageRequest.of(pageNo,pageSize, Sort.by(Sort.Direction.DESC,sortBy));
        Page<Load> Load = loadRepository.findAll(pageable);
        LOGGER.info("load saved successfully");
        return Load;

    }

    @Override
    public Load getProductDetailsByID(int id) {
        Optional<Load> load = loadRepository.findById(id);
        return load.get();

    }

    @Override
    public List<Load> saveAllDetails(List<Load> product) {
        return null;
    }

    @Override
    public String deleteDetailsById(int id) {
        return null;
    }


    @Override
    public Load getLoadDetailsByID(int id) {
        return null;
    }
}
