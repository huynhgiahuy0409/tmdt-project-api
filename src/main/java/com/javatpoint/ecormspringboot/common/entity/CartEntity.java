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

    @OneToMany(mappedBy = "cart",cascade = {CascadeType.ALL})
    private Set<PendingItemEntity> pendingOrders = new HashSet<PendingItemEntity>();

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private UserEntity user;
}
