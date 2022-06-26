package com.javatpoint.ecormspringboot.common.request;

import com.javatpoint.ecormspringboot.common.dto.DistrictDTO;
import com.javatpoint.ecormspringboot.common.dto.ProvinceDTO;
import com.javatpoint.ecormspringboot.common.dto.WardDTO;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddressRequest {
    private String fullName;
    private String phoneNumber;
    private String detailAddress;
    private long wardId;
    private long districtId;
    private long provinceId;
    private long status;
}
