package com.javatpoint.ecormspringboot.response;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class MomoTransactionsResponse {
    private List<MomoTransactionResponse> transactions;
}
