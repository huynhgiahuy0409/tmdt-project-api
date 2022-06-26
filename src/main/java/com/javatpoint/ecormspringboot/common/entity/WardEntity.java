package com.javatpoint.ecormspringboot.common.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

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

    @OneToMany(mappedBy = "ward", cascade = {CascadeType.REMOVE})
    private Set<AddressEntity> addresses = new HashSet<AddressEntity>();
}
