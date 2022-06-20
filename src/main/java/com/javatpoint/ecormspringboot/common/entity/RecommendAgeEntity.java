package com.javatpoint.ecormspringboot.common.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "recommend")
@Getter
@Setter
public class RecommendAgeEntity extends BaseEntity{
    private String name;
    private String code;

    @OneToMany(mappedBy = "recommend")
    private Set<ProductEntity> products;


}
