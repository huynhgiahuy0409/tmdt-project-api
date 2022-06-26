package com.javatpoint.ecormspringboot.common.entity;

import com.javatpoint.ecormspringboot.common.entity.BaseEntity;
import com.javatpoint.ecormspringboot.common.entity.ProvinceEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "district")
@Getter
@Setter
public class DistrictEntity extends BaseEntity {
    @Column(name = "_name")
    private String name;

    @Column(name = "_prefix")
    private String prefix;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "_province_id")
    private ProvinceEntity province;

    @OneToMany(mappedBy = "district", cascade = CascadeType.ALL)
    private Set<WardEntity> wards = new HashSet<WardEntity>();

    @OneToMany(mappedBy = "district", cascade = {CascadeType.REMOVE})
    private Set<AddressEntity> addresses = new HashSet<AddressEntity>();
}
