package com.javatpoint.ecormspringboot.common.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "status")
@Getter
@Setter
public class StatusEntity extends BaseEntity{
    private String name;
    private String code;

    @OneToMany(mappedBy = "status", cascade = CascadeType.ALL)
    private Set<ProductEntity> products = new HashSet<ProductEntity>();



}
