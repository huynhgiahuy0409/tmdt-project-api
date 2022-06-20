package com.javatpoint.ecormspringboot.common.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "ward")
@Getter
@Setter
public class WardEntity extends BaseEntity{
    @Column(name = "_name")
    private String name;

    @Column(name = "_prefix")
    private String prefix;

    @ManyToOne
    @JoinColumn(name = "_province_id")
    private ProvinceEntity province;

    @ManyToOne
    @JoinColumn(name = "_district_id")
    private DistrictEntity district;
}
