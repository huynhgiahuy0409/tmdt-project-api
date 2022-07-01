package com.javatpoint.ecormspringboot.common.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Set;

@Getter
@Setter
public class CartDTO {
    private long id;
    private List<CartItemDTO> cartItems;
}
