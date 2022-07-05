package com.javatpoint.ecormspringboot.common.model;

import com.javatpoint.ecormspringboot.common.dto.AddressDTO;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
public class ShopUser {
    private Long id;

    private String name;

    private String username;

    private String fullName;

    private Integer status;

    private String gender;

    private Set<AddressDTO> addresses;

    private String email;

    private String phoneNumber;

    private String role;
}
