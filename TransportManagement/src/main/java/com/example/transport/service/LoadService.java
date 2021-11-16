package com.example.transport.service;

import com.example.transport.dto.LoadDTO;
import com.example.transport.entity.Load;
import org.springframework.data.domain.Page;

import java.util.List;

public interface LoadService {



    LoadDTO addOrder(LoadDTO order);

    Page<Load> listAllDetails(int pageNo , int pageSize, String sortBy);

    Load getProductDetailsByID(int id);

    List<Load> saveAllDetails(List<Load> product);

    String deleteDetailsById(int id);

    LoadDTO addLoad(LoadDTO load);

    Load getLoadDetailsByID(int id);

  /*  List<OrderDTO> saveAllDetails(List<OrderDTO> product);

    List<OrderDTO> listAllDetails();

    OrderDTO getProductDetailsByID(int id);

    OrderDTO updateProductDetails(OrderDTO product);

    String deleteDetailsById(int id);*/
}
    