package com.javatpoint.ecormspringboot.common.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PendingItemRequest {
    private long productId;
    private int quantity;
}
