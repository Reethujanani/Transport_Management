package com.example.transport.service.ServiceImpl;

import com.example.transport.dto.VehicleDTO;
import com.example.transport.entity.User;
import com.example.transport.entity.Vehicles;
import com.example.transport.entity.VehicleType;
import com.example.transport.repository.VehicleRepository;
import com.example.transport.repository.VehicleTypeRepository;
import com.example.transport.service.VehicleService;

import com.sun.istack.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class VehicleServiceImpl implements VehicleService {

    private static final Logger LOGGER = null;
    @Autowired
    private VehicleRepository Vehiclerepository;

    @Autowired
    private VehicleTypeRepository vehicleTypeRepository;

    @Override
    public VehicleDTO addVehicle(VehicleDTO vehicleDTO) {
        Vehicles vehicle = new Vehicles();
        try {
        Optional<VehicleType> vehicleType = vehicleTypeRepository.findById(vehicleDTO.getVehicleTypeId());
        vehicle.setVehicleType(vehicleType.get());
        vehicle.setId(vehicleDTO.getId());
        vehicle.setVehicleName(vehicleDTO.getVehicleName());
        vehicle.setVehicleNumber(vehicleDTO.getVehicleNumber());
        vehicle.setVehicleDescription(vehicleDTO.getVehicleDescription());
        vehicle.setIsActive(vehicleDTO.getIsActive());
        vehicle.setIsDeleted(vehicleDTO.getIsDeleted());
            Vehiclerepository.save(vehicle);
        }catch (Exception e){
            e.getMessage();
        }
        return vehicleDTO;
    }

    @Override
    public VehicleDTO updateVehicleDetails(VehicleDTO vehicle) {


        Vehicles vehicle1 = new Vehicles();
        Optional<VehicleType> vehicleType = vehicleTypeRepository.findById(vehicle.getVehicleTypeId());
        vehicle1.setVehicleType(vehicleType.get());
        vehicle1.setId(vehicle.getId());
        vehicle1.setVehicleName(vehicle.getVehicleName());
        vehicle1.setVehicleNumber(vehicle.getVehicleNumber());
        vehicle1.setVehicleDescription(vehicle.getVehicleDescription());
        vehicle1.setIsActive(vehicle.getIsActive());
        vehicle1.setIsDeleted(vehicle.getIsDeleted());
        Vehiclerepository.save(vehicle1);
        LOGGER.info("user updated successfully");
        return null;
    }


    @Override
    public Vehicles getProductDetailsByID(int id) {
        Optional<Vehicles> vehicle = Vehiclerepository.findById(id);
        return vehicle.get();

    }


    @Override
    public Page<Vehicles> listAllDetails(int pageNo , int pageSize, String sortBy) {
        Pageable pageable = PageRequest.of(pageNo,pageSize, Sort.by(Sort.Direction.DESC,sortBy));
        Page<Vehicles> Vehicle = Vehiclerepository.findAll(pageable);
        LOGGER.info("user saved successfully");
        return Vehicle;
    }

    @Override
    public List<Vehicles> listAllDetails() {
        return null;
    }


    @Override
    public String deleteDetailsById(int id) {
        Vehiclerepository.deleteById(id);
         return "Successfully deleted";
    }
}
