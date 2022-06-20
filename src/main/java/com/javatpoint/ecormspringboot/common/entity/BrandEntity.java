package com.javatpoint.ecormspringboot.common.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "brand")
@Getter
@Setter
public class BrandEntity extends  BaseEntity{
    private String name;
    private String code;
    private String status;

    @OneToMany(mappedBy = "brand")
    private Set<ProductEntity> products;

    @OneToOne(mappedBy = "brand")
    private ImageEntity logo;


}
