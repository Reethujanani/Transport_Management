package com.example.transport.controller;

import com.example.transport.dto.VehicleDTO;
import com.example.transport.entity.Vehicles;
import com.example.transport.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vehicle")
public class VehicleController {

    @Autowired
    private VehicleService VehicleService;

    //Post Method
    @PostMapping("/post")
    public VehicleDTO addVehicle(@RequestBody VehicleDTO Vehicle  ){
        return VehicleService.addVehicle(Vehicle);
    }

    //read method
    @GetMapping("/gets")
    public List<Vehicles> getAllDetails(){
        return VehicleService.listAllDetails();
    }
    //read method by ID
    @GetMapping("/getById/{id}")
    public Vehicles getDetailsByID(@PathVariable int id){

        return VehicleService.getProductDetailsByID(id);
    }

    //read method
    @GetMapping("/get")
    public Page<Vehicles> getAllDetails(@RequestParam(value = "pageNo",defaultValue = "0") int pageNo,
                                       @RequestParam(value = "pageSize",defaultValue = "10") int pageSize,
                                       @RequestParam(value = "sortBy",defaultValue = "id") String sortBy){
        return VehicleService.listAllDetails(pageNo,pageSize,sortBy);
    }

    //update method
    @PutMapping("/update")
    public VehicleDTO updateStudent(@RequestBody VehicleDTO Vehicle) {
        return VehicleService.updateVehicleDetails(Vehicle);
    }


    //delete method+
    @DeleteMapping("/delete/{id}")
    public String deleteStudent(@PathVariable int id){
        return VehicleService.deleteDetailsById(id);
    }
}


