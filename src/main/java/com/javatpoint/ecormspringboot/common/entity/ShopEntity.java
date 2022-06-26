package com.javatpoint.ecormspringboot.common.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "shop")
@Getter
@Setter
public class ShopEntity extends BaseEntity {
	private String name;

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "image_id")
	private ImageEntity avatar;

	private int numberReview = 0;

	private int numberProduct = 0;

	private int responseRate = 0;

	private int responseTime = 0;

	private int lastAccess;

	private int followers = 0;

	@OneToMany(mappedBy = "shop", cascade = CascadeType.PERSIST)
	private Set<ProductEntity> products = new HashSet<ProductEntity>();

	@OneToOne
	@JoinColumn(name =  "user_id")
	private UserEntity user;

	@OneToMany(mappedBy = "shop", cascade = CascadeType.ALL)
	private Set<CartItemEntity> cartItems = new HashSet<CartItemEntity>();
}
