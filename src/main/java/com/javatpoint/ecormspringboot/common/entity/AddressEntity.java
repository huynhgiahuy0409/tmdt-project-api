package com.javatpoint.ecormspringboot.common.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "address")
@Getter
@Setter
public class AddressEntity extends BaseEntity{
    private String fullName;
    private String numberPhone;
    private String detailAddress;
    private String ward;
    private String district;
    private String province;
    private boolean isDefault;

    @ManyToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "user_id")
    private UserEntity user;
}
