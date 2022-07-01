package com.javatpoint.ecormspringboot.common.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "province")
@Getter
@Setter
public class ProvinceEntity extends BaseEntity{
    @Column(name = "_name")
    private String name;

    @Column(name = "_code")
    private String code;

    @Column(name = "_domain")
    private String domain;

    @OneToMany(mappedBy = "province", cascade = CascadeType.ALL)
    private Set<DistrictEntity> districts = new HashSet<DistrictEntity>();


    @OneToMany(mappedBy = "province", cascade = CascadeType.ALL)
    private Set<WardEntity> wards = new HashSet<WardEntity>();

    @OneToMany(mappedBy = "province", cascade = {CascadeType.REMOVE})
    private Set<AddressEntity> addresses = new HashSet<AddressEntity>();
}
