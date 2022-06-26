package com.javatpoint.ecormspringboot.common.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "pending_item")
@Getter
@Setter
public class PendingItemEntity extends BaseEntity{

    @ManyToOne
    @JoinColumn(name = "product_id")
    private ProductEntity product;

    private int quantity;

    @ManyToOne
    @JoinColumn(name = "cart_item_id")
    private CartItemEntity cartItem;
}
