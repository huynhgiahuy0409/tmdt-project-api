package com.javatpoint.ecormspringboot.response;

import com.javatpoint.ecormspringboot.common.entity.OrderItemEntity;
import com.javatpoint.ecormspringboot.common.entity.ShopEntity;
import com.javatpoint.ecormspringboot.common.entity.UserEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.Date;
import java.util.List;

@Getter
@Setter
public class OrderResponse {
    private long id;

    private Date createdDate;

    private List<OrderItemResponse> orderItems;

    private String status;

    private String orderBy;

    private String sendBy;

    private String orderPhoneNumber;

    private String sendPhoneNumber;

    private String orderAddress;

    private String sendAddress;

    private double cartItemCost;

    private double shippingCost;

    private double paymentCost;

    private String paymentMethod;

    private String paymentStatus;

    private String digitBillFilename;

    private String digitalBillHash;
}
