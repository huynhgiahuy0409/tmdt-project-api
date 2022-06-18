package com.javatpoint.ecormspringboot.common.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.javatpoint.ecormspringboot.common.entity.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Nationalized;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Data
public class ProductDTO {
    private Long id;
    Date createdDate;
    private String name;
    private String SKU;
    private String description;
    private double sourcePrice;
    private double discountPercent;
    private double buyPrice;
    private int repository;
    private OriginDTO origin;
    private StatusDTO status;
    private Set<ImageDTO> images;
    private CategoryDTO category;
    private MaterialDTO material;
    private SizeDTO size;
    private BrandDTO brand;
    private RecommendAgeDTO recommend;
}
