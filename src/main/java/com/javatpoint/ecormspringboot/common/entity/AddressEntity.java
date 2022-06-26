package com.javatpoint.ecormspringboot.common.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "address")
@Getter
@Setter
public class AddressEntity extends BaseEntity {
    private String fullName;
    private String phoneNumber;
    private String detailAddress;

    @ManyToOne
    @JoinColumn(name = "ward_id")
    private WardEntity ward;

    @ManyToOne
    @JoinColumn(name = "district_id")
    private DistrictEntity district;

    @ManyToOne
    @JoinColumn(name = "province_id")
    private ProvinceEntity province;

    private long status;

    @ManyToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "user_id")
    private UserEntity user;
}
