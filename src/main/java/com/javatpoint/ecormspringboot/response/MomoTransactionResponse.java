package com.javatpoint.ecormspringboot.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MomoTransactionResponse {
    private String transactionsId;
    private String type;
    private String partnerId;
    private String partner;
    private String amount;
    private String content;
    private String time;
}
