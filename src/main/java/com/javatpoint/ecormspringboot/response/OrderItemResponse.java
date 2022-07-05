package com.javatpoint.ecormspringboot.response;

import com.javatpoint.ecormspringboot.common.dto.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.Set;

@Getter
@Setter
public class OrderItemResponse {
    private ProductDTO product;

    private String quantity;
}
