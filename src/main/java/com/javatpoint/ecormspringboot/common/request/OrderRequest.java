package com.javatpoint.ecormspringboot.common.request;

import com.javatpoint.ecormspringboot.common.dto.ShopDTO;
import com.javatpoint.ecormspringboot.common.dto.UserDTO;
import com.javatpoint.ecormspringboot.common.entity.OrderItemEntity;
import com.javatpoint.ecormspringboot.common.entity.ShopEntity;
import com.javatpoint.ecormspringboot.common.entity.UserEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.List;

@Getter
@Setter
public class OrderRequest {
    private List<OrderItemRequest> orderItems;

    private long shopId;

    private long userId;

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

}
