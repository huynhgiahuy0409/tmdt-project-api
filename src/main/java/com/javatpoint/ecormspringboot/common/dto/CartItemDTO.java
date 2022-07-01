package com.javatpoint.ecormspringboot.common.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Set;

@Getter
@Setter
public class CartItemDTO {
    long id;
    private List<PendingItemDTO> pendingItems;
    private ShopDTO shop;
}
