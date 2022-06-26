package com.javatpoint.ecormspringboot.common.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddressDTO {
    private long id;
    private String fullName;
    private String phoneNumber;
    private String detailAddress;
    private WardDTO ward;
    private DistrictDTO district;
    private ProvinceDTO province;
    private long status;
}
