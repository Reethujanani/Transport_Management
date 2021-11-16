package com.example.transport.dto;

import lombok.Data;

import java.util.List;

@Data

public class UserDTO {

    private int id;
    private String userName;
    private String password;
    private String mobileNo;
    private String city;
    private int isActive;
    private int isDeleted;

    private List<RoleDTO> roleList;


}
