package com.javatpoint.ecormspringboot.common.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DigitalBillRequest {
    String encryptHash;
    long orderId;
}
