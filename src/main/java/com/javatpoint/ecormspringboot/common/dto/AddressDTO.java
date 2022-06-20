package com.javatpoint.ecormspringboot.common.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddressDTO {
    private String fullName;
    private String numberPhone;
    private String detailAddress;
    private String ward;
    private String district;
    private String province;
    private boolean isDefault;
}
