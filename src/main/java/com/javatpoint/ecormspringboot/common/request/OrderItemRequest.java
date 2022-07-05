package com.javatpoint.ecormspringboot.common.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderItemRequest {

    private long productId;

    private int quantity;

}
