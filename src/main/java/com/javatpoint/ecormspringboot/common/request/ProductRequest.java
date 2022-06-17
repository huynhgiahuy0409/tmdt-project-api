package com.javatpoint.ecormspringboot.common.request;

import com.javatpoint.ecormspringboot.common.dto.SizeDTO;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class ProductRequest {
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

}
