package com.example.transport.dto;

import lombok.Data;

@Data
public class VehicleDTO {

    private int id;
    private int vehicleTypeId;
    private String vehicleName;
    private int vehicleNumber;
    private String vehicleDescription;
    private int isActive;
    private int isDeleted;
}
