package com.javatpoint.ecormspringboot.common.dto;

import com.javatpoint.ecormspringboot.common.entity.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

public class ProductDTO {
    private String name;
    private String SKU;
    private String description;
    private double sourcePrice;
    private double discountPercent;
    private int repository;
    private SizeDTO size;
    private String originCode;
    private String statusCode;
    private String categoryCode;
    private String materialCode;
    private String brandCode;
    private String recommendAgeCode;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSKU() {
        return SKU;
    }

    public void setSKU(String SKU) {
        this.SKU = SKU;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getSourcePrice() {
        return sourcePrice;
    }

    public void setSourcePrice(double sourcePrice) {
        this.sourcePrice = sourcePrice;
    }

    public double getDiscountPercent() {
        return discountPercent;
    }

    public void setDiscountPercent(double discountPercent) {
        this.discountPercent = discountPercent;
    }

    public int getRepository() {
        return repository;
    }

    public void setRepository(int repository) {
        this.repository = repository;
    }

    public SizeDTO getSize() {
        return size;
    }

    public void setSize(SizeDTO size) {
        this.size = size;
    }

    public String getOriginCode() {
        return originCode;
    }

    public void setOriginCode(String originCode) {
        this.originCode = originCode;
    }

    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    public String getCategoryCode() {
        return categoryCode;
    }

    public void setCategoryCode(String categoryCode) {
        this.categoryCode = categoryCode;
    }

    public String getMaterialCode() {
        return materialCode;
    }

    public void setMaterialCode(String materialCode) {
        this.materialCode = materialCode;
    }

    public String getBrandCode() {
        return brandCode;
    }

    public void setBrandCode(String brandCode) {
        this.brandCode = brandCode;
    }

    public String getRecommendAgeCode() {
        return recommendAgeCode;
    }

    public void setRecommendAgeCode(String recommendAgeCode) {
        this.recommendAgeCode = recommendAgeCode;
    }

    @Override
    public String toString() {
        return "ProductDTO{" +
                "name='" + name + '\'' +
                ", SKU='" + SKU + '\'' +
                ", description='" + description + '\'' +
                ", sourcePrice=" + sourcePrice +
                ", discountPercent=" + discountPercent +
                ", repository=" + repository +
                ", size=" + size +
                ", originCode='" + originCode + '\'' +
                ", statusCode='" + statusCode + '\'' +
                ", categoryCode='" + categoryCode + '\'' +
                ", materialCode='" + materialCode + '\'' +
                ", brandCode='" + brandCode + '\'' +
                ", recommendAgeCode='" + recommendAgeCode + '\'' +
                '}';
    }
}
