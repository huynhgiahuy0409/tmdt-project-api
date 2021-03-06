package com.javatpoint.ecormspringboot.common.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Nationalized;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name = "product")
@Getter
@Setter
public class ProductEntity extends BaseEntity {
	@Column(name = "name")
	@Nationalized
	private String name;
	private String SKU;
	@Column(name = "description", length = 255, nullable = false)
	@Nationalized
	private String description;
	private double sourcePrice;
	private double discountPercent;
	private double buyPrice;
	private int repository;
	private int view;
	@ManyToOne
	@JoinColumn(name = "origin_id")
	@Nationalized
	private OriginEntity origin;

	@ManyToOne
	@JoinColumn(name = "status_id")
	@Nationalized
	private StatusEntity status;

	@OneToMany(mappedBy = "product", cascade = {CascadeType.REMOVE,CascadeType.REFRESH})
	private Set<ImageEntity> images = new HashSet<ImageEntity>();

	@ManyToOne
	@JoinColumn(name = "category_id")
	private CategoryEntity category;

	@ManyToOne
	@JoinColumn(name = "material_id")
	private MaterialEntity material;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "size_id")
	private SizeEntity size;

	@ManyToOne
	@JoinColumn(name = "brand_id")
	private BrandEntity brand;

	@ManyToOne
	@JoinColumn(name = "recommend_id")
	private RecommendAgeEntity recommend;

	@OneToMany(mappedBy = "product", cascade = {CascadeType.REMOVE,CascadeType.REFRESH})
	private Set<PendingItemEntity> pendingItems= new HashSet<PendingItemEntity>();

	@ManyToOne
	@JoinColumn(name = "shop_id")
	private ShopEntity shop;

	@OneToMany(mappedBy = "product",cascade = {CascadeType.REFRESH} )
	private List<OrderItemEntity> orderItems = new ArrayList<OrderItemEntity>();
}
