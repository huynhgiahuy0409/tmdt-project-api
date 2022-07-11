package com.javatpoint.ecormspringboot.common.api;

import com.javatpoint.ecormspringboot.common.entity.*;
import com.javatpoint.ecormspringboot.common.request.OrderItemRequest;
import com.javatpoint.ecormspringboot.common.request.OrderRequest;
import com.javatpoint.ecormspringboot.common.util.constance.SystemContance;
import com.javatpoint.ecormspringboot.response.MomoTransactionResponse;
import com.javatpoint.ecormspringboot.response.MomoTransactionsResponse;
import com.javatpoint.ecormspringboot.response.OrderResponse;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "/api")
public class MomoController {

    @GetMapping("/transaction-history/momo")
    @Transactional
    public ResponseEntity<MomoTransactionsResponse> getTransactionHistory() throws IOException {
        String URL = "https://momo.k04team.com/api/v2/lich-su-giao-dich.asp";
        RestTemplate template = new RestTemplateBuilder().build();
        Map<String, String> map = new HashMap<>();
        map.put("APIKey", SystemContance.MOMO_API_KEY);
        map.put("phone", SystemContance.MOMO_PHONE);
        map.put("limit", SystemContance.MOMO_LIMIT_TRANSACTION_HISTORY);
        ResponseEntity<Object> response = template.postForEntity(URL, map, Object.class);
        return ResponseEntity.ok(template.postForEntity(URL, map, MomoTransactionsResponse.class).getBody());
    }

}
