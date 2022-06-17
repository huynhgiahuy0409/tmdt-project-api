package com.javatpoint.ecormspringboot.common.dto;

import lombok.Data;

@Data
public class UserDTO {
    private Long id;

    private String name;

    private String username;

    private String password;

    private String fullName;

    private Integer status;

    private String gender;

    private String address;

    private String email;

    private String phoneNumber;

    private String role;

}
