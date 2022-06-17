package com.javatpoint.ecormspringboot.common.entity;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "brand")
@Data
public class BrandEntity extends  BaseEntity{
    private String name;
    private String code;
    private String status;

    @OneToMany(mappedBy = "brand")
    private Set<ProductEntity> products;

    @OneToOne(mappedBy = "brand")
    private ImageEntity logo;


}
