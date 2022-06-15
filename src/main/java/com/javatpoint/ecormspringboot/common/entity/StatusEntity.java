package com.javatpoint.ecormspringboot.common.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "status")
public class StatusEntity extends BaseEntity{
    private String name;
    private String code;

    @OneToMany(mappedBy = "status")
    private Set<ProductEntity> products = new HashSet<ProductEntity>();

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<ProductEntity> getProducts() {
        return products;
    }

    public void setProducts(Set<ProductEntity> products) {
        this.products = products;
    }


}
