package com.example.transport.service.ServiceImpl;

import com.example.transport.dto.VehicleTypeDTO;
import com.example.transport.entity.User;
import com.example.transport.entity.Vehicles;
import com.example.transport.entity.VehicleType;
import com.example.transport.repository.VehicleTypeRepository;
import com.example.transport.service.VehicleTypeService;
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

public class VehicleTypeServiceImpl implements VehicleTypeService {

    private static final Logger LOGGER = null;
    @Autowired
    private VehicleTypeRepository VehicleTypeRepository;


    @Override
    public VehicleTypeDTO addVehicleType(VehicleTypeDTO vehicleType) {
        VehicleType vehicleType1 = new VehicleType();

        vehicleType1.setVehicleTypeName(vehicleType.getVehicleTypeName());
        vehicleType1.setVehicleTypeDescription(vehicleType.getVehicleTypeDescription());
        vehicleType1.setIsActive(vehicleType.getIsActive());
        vehicleType1.setIsDeleted(vehicleType.getIsDeleted());
        try {
            VehicleTypeRepository.save(vehicleType1);
        }catch (Exception e){
            e.getMessage();
        }
        return null;
    }


    @Override
    public Page<VehicleType> listAllDetails(int pageNo , int pageSize, String sortBy) {
        Pageable pageable = PageRequest.of(pageNo,pageSize, Sort.by(Sort.Direction.DESC,sortBy));
        Page<VehicleType> vehicleType = VehicleTypeRepository.findAll(pageable);
         return vehicleType;
    }

    @Override
    public VehicleType getProductDetailsByID(int id) {
        Optional<VehicleType> vehicleType = VehicleTypeRepository.findById(id);
        return vehicleType.get();
    }

    @Override
    public VehicleType updateProductDetails(Object spare_parts_type) {
        return null;
    }


    @Override
    public String deleteDetailsById(int id) {
        VehicleTypeRepository.deleteById(id);
        LOGGER.info("user deleted successfully");
        return "Success";
    }


    @Override
    public List<VehicleType> saveAllDetails(List<VehicleType> product) {
        return null;
    }
}
