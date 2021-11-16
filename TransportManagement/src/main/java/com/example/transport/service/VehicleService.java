package com.example.transport.service;

import com.example.transport.dto.VehicleDTO;
import com.example.transport.entity.Vehicles;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface VehicleService {

    Page<Vehicles> listAllDetails(int pageNo, int pageSize, String sortBy);

    List<Vehicles> listAllDetails();

    Vehicles getProductDetailsByID(int id);

    String deleteDetailsById(int id);

    VehicleDTO addVehicle(VehicleDTO vehicle);

    VehicleDTO updateVehicleDetails(VehicleDTO vehicle);
}
