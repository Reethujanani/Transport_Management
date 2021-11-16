package com.example.transport.dto;

import lombok.Data;

@Data

public class VehicleTypeDTO {

    private int id;
    private String vehicleTypeName;
    private String vehicleTypeDescription;
    private int isActive;
    private int isDeleted;

}
