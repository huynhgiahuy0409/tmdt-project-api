package com.javatpoint.ecormspringboot.common.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "recommend")
@Data
public class RecommendAgeEntity extends BaseEntity{
    private String name;
    private String code;

    @OneToMany(mappedBy = "recommend")
    private Set<ProductEntity> products;


}
