package com.javatpoint.ecormspringboot.common.dto;

import com.javatpoint.ecormspringboot.common.model.PendingProductResponse;
import lombok.Data;

import java.util.Set;

@Data
public class PendingItemDTO {
    private PendingProductResponse product;
    private int quantity;
}
