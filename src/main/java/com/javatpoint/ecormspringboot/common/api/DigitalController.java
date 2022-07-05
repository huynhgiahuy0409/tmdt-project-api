package com.javatpoint.ecormspringboot.common.api;

import com.javatpoint.ecormspringboot.common.request.DigitalBillRequest;
import com.javatpoint.ecormspringboot.common.service.imp.OrderService;
import com.javatpoint.ecormspringboot.common.service.imp.VerifyDigitalBillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api")
public class DigitalController {

    @Autowired
    private VerifyDigitalBillService verifyDigitalBillService;

    @Autowired
    private OrderService orderService;

    @PostMapping("/verify/user/{userId}/digital-bill")
    public ResponseEntity<Boolean> verifyDigitalBill(@PathVariable long userId, @RequestBody DigitalBillRequest digitalBillRequest){
        System.out.println(userId);
        System.out.println(digitalBillRequest.getEncryptHash());
        System.out.println(digitalBillRequest.getOrderId());
        boolean isVerify = verifyDigitalBillService.verifyDigitalBill(digitalBillRequest.getEncryptHash(),digitalBillRequest.getOrderId() + "",userId);
        return ResponseEntity.ok(isVerify);
    }
}
