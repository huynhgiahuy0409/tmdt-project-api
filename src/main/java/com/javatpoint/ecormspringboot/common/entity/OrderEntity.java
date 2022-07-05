package com.javatpoint.ecormspringboot.common.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "order_t")
@Getter
@Setter
public class OrderEntity extends BaseEntity{
    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<OrderItemEntity> orderItems;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "shop_id")
    private ShopEntity shop;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;

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

    private String digitBillFilename;

    private String digitalBillHash;
}
