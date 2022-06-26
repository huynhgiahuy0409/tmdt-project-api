package com.javatpoint.ecormspringboot.common.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
import java.util.SortedSet;

@Entity
@Table(name = "cart_item")
@Getter
@Setter
public class CartItemEntity extends BaseEntity{
    @OneToMany(mappedBy = "cartItem", cascade = CascadeType.ALL)
    private Set<PendingItemEntity> pendingItems = new HashSet<PendingItemEntity>();

    @ManyToOne
    @JoinColumn(name = "shop_id")
    private ShopEntity shop;

    @ManyToOne
    @JoinColumn(name = "cart_id")
    private CartEntity cart;
}
