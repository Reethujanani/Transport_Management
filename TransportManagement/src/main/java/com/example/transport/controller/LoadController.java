package com.example.transport.controller;

import com.example.transport.dto.LoadDTO;
import com.example.transport.entity.Load;
import com.example.transport.service.LoadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/load")
public class LoadController {

    @Autowired
    private LoadService LoadService;

    //Post Method
    @PostMapping("/post")
    public LoadDTO addLoad(@RequestBody LoadDTO Load){
        return LoadService.addLoad(Load);
    }
 @PostMapping("/createList")
    public List<Load> saveLoad(@RequestBody List<Load> Load){
        return LoadService.saveAllDetails(Load);
    }

    //read method
    @GetMapping("/get")
    public Page<Load> listAllDetails(@RequestParam(value = "pageNo",defaultValue = "0") int pageNo,
                                     @RequestParam(value = "pageSize",defaultValue = "10") int pageSize,
                                     @RequestParam(value = "sortBy",defaultValue = "id") String sortBy){
        return LoadService.listAllDetails(pageNo,pageSize,sortBy);
    }
    //read method by ID
    @GetMapping("/getById/{id}")
    public Load getDetailsByID(@PathVariable int id){

        return LoadService.getLoadDetailsByID(id);
    }


/*    @PutMapping("/update")
    public Load updateStudent(@RequestBody Load load) {
        return LoadService.updateLoadDetails(Load);
    }*/



    @DeleteMapping("/delete/{id}")
    public String deleteStudent(@PathVariable int id){
        return LoadService.deleteDetailsById(id);
    }

}


