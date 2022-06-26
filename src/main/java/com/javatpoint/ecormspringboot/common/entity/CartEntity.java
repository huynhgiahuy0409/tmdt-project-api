package com.javatpoint.ecormspringboot.common.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "cart")
@Getter
@Setter
public class CartEntity extends BaseEntity{

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private UserEntity user;

    @OneToMany(mappedBy = "cart",cascade = {CascadeType.ALL})
    private Set<CartItemEntity> cartItems = new HashSet<CartItemEntity>();
}
