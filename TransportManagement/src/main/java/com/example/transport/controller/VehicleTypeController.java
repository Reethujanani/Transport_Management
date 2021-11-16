package com.example.transport.controller;

import com.example.transport.dto.VehicleTypeDTO;
import com.example.transport.entity.VehicleType;
import com.example.transport.service.VehicleTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class VehicleTypeController {

    @Autowired
    private VehicleTypeService VehicleTypeService;
    private Object VehicleType;

    //Post Method
    @PostMapping("/VehicleType/post")
    public VehicleTypeDTO addVehicleType(@RequestBody VehicleTypeDTO VehicleType  ){
        return VehicleTypeService.addVehicleType(VehicleType);
    }
    @PostMapping("/VehicleType/createList")
    public List<VehicleType> saveStudent(@RequestBody List<VehicleType> Vehicle){
        return VehicleTypeService.saveAllDetails(Vehicle);
    }

    //read method by ID
    @GetMapping("/VehicleType/getById")
    public VehicleType getDetailsByID(@RequestParam int id){

        return VehicleTypeService.getProductDetailsByID(id);
    }
    //read method
    @GetMapping("/VehicleType/get")
    public Page<VehicleType> getAllDetails(@RequestParam(value = "pageNo",defaultValue = "0") int pageNo,
                                           @RequestParam(value = "pageSize",defaultValue = "10") int pageSize,
                                           @RequestParam(value = "sortBy",defaultValue = "id") String sortBy){
        return VehicleTypeService.listAllDetails(pageNo,pageSize,sortBy);
    }

    //update method
    @PutMapping("/VehicleType/update")
    public VehicleType updateStudent(@RequestBody VehicleType VehicleType) {
        return VehicleTypeService.updateProductDetails(VehicleType);
    }


    //delete method+
    @DeleteMapping("/delete/{id}")
    public String deleteStudent(@PathVariable int id){
        return VehicleTypeService.deleteDetailsById(id);
    }
}

