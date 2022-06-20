package com.javatpoint.ecormspringboot.common.dto;

import lombok.Data;

import java.util.List;
import java.util.Set;

@Data
public class CartDTO {
    Set<PendingItemDTO> pendingOrders;

}
