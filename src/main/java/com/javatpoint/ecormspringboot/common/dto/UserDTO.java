package com.javatpoint.ecormspringboot.common.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
public class UserDTO {
    private Long id;

    private String name;

    private String username;

    private String password;

    private String fullName;

    private Integer status;

    private String gender;

    private Set<AddressDTO> addresses;

    private String email;

    private String phoneNumber;

    private String role;

    private CartDTO cart;

    private ShopDTO shop;
}
