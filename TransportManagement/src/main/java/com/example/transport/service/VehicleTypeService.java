package com.example.transport.service;

import com.example.transport.dto.VehicleTypeDTO;
import com.example.transport.entity.VehicleType;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface VehicleTypeService {

    Page<VehicleType> listAllDetails(int pageNo , int pageSize, String sortBy);

    VehicleType getProductDetailsByID(int id);

    VehicleType updateProductDetails(Object spare_parts_type);

    String deleteDetailsById(int id);

    List<VehicleType> saveAllDetails(List<VehicleType> product);

    VehicleTypeDTO addVehicleType(VehicleTypeDTO vehicleType);
}
