package com.javatpoint.ecormspringboot.common.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
public class CartItemDTO {
    private Set<PendingItemDTO> pendingItems;
    private ShopDTO shop;
}
