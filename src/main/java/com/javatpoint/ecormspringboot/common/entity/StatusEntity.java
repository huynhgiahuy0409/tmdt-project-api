package com.javatpoint.ecormspringboot.common.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "status")
@Data
public class StatusEntity extends BaseEntity{
    private String name;
    private String code;

    @OneToMany(mappedBy = "status", cascade = CascadeType.ALL)
    private Set<ProductEntity> products = new HashSet<ProductEntity>();



}
