package com.javatpoint.ecormspringboot.common.entity;

import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "brand")
public class BrandEntity extends  BaseEntity{
    private String name;
    private String code;
    private String status;

    @OneToMany(mappedBy = "brand")
    private Set<ProductEntity> products;

    @OneToOne(mappedBy = "brand")
    private ImageEntity logo;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Set<ProductEntity> getProducts() {
        return products;
    }

    public void setProducts(Set<ProductEntity> products) {
        this.products = products;
    }

    public ImageEntity getLogo() {
        return logo;
    }

    public void setLogo(ImageEntity logo) {
        this.logo = logo;
    }
}
