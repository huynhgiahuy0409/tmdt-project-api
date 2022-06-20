package com.javatpoint.ecormspringboot.common.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "origin")
@Getter
@Setter
public class OriginEntity extends BaseEntity{
    String name;
    String code;
    @OneToMany(mappedBy = "origin", cascade = CascadeType.ALL)
    private Set<ProductEntity> products = new HashSet<ProductEntity>();
}
