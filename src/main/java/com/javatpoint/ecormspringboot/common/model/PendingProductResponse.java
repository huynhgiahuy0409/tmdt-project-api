package com.javatpoint.ecormspringboot.common.model;

import com.javatpoint.ecormspringboot.common.dto.ImageDTO;
import lombok.Data;

import java.util.Set;

@Data
public class PendingProductResponse {
    private long id;
    private String name;
    private double sourcePrice;
    private double buyPrice;
    private Set<ImageDTO> images;
}
