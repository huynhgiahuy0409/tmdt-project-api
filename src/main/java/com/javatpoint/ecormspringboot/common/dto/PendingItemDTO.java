package com.javatpoint.ecormspringboot.common.dto;

import com.javatpoint.ecormspringboot.common.model.PendingProductResponse;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
public class PendingItemDTO {
    private long id;
    private ProductDTO product;
    private int quantity;
}
