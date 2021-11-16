package com.example.transport.dto;

import lombok.Data;

import java.util.List;

@Data
public class LoadDTO {

    private int id;
    private int userid;
    private String loadName;
    private String sourceFrom;
    private String toDestination;
    private int isActive;
    private int isDeleted;
    private List<VehicleDTO> vehicleDTOList;

}
