package com.javatpoint.ecormspringboot.common.entity;

import org.hibernate.annotations.Nationalized;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name = "product")
public class ProductEntity extends BaseEntity {
	@Column(name = "name")
	@Nationalized
	private String name;
	private String SKU;
	@Column(name = "description", columnDefinition = "TEXT")
	@Nationalized
	private String description;
	private double sourcePrice;
	private double discountPercent;
	private int repository;
	private double weight;
	@Column(name = "origin")
	@Nationalized
	private String origin;

	@ManyToOne
	@JoinColumn(name = "status_id")
	@Nationalized
	private StatusEntity status;

	@OneToMany(mappedBy = "product")
	private Set<ImageEntity> images = new HashSet<ImageEntity>();

	@ManyToOne
	@JoinColumn(name = "category_id")
	private CategoryEntity category;

	@ManyToOne
	@JoinColumn(name = "material_id")
	private MaterialEntity material;

	@OneToOne
	@JoinColumn(name = "size_id")
	private SizeEntity size;

	@ManyToOne
	@JoinColumn(name = "brand_id")
	private BrandEntity brand;

	@ManyToOne
	@JoinColumn(name = "recommend_id")
	private RecommendAgeEntity recommend;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSKU() {
		return SKU;
	}

	public void setSKU(String SKU) {
		this.SKU = SKU;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getSourcePrice() {
		return sourcePrice;
	}

	public void setSourcePrice(double sourcePrice) {
		this.sourcePrice = sourcePrice;
	}

	public double getDiscountPercent() {
		return discountPercent;
	}

	public void setDiscountPercent(double discountPercent) {
		this.discountPercent = discountPercent;
	}

	public int getRepository() {
		return repository;
	}

	public void setRepository(int repository) {
		this.repository = repository;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public String getOrigin() {
		return origin;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}

	public StatusEntity getStatus() {
		return status;
	}

	public void setStatus(StatusEntity status) {
		this.status = status;
	}

	public Set<ImageEntity> getImages() {
		return images;
	}

	public void setImages(Set<ImageEntity> images) {
		this.images = images;
	}

	public CategoryEntity getCategory() {
		return category;
	}

	public void setCategory(CategoryEntity category) {
		this.category = category;
	}

	public MaterialEntity getMaterial() {
		return material;
	}

	public void setMaterial(MaterialEntity material) {
		this.material = material;
	}

	public SizeEntity getSize() {
		return size;
	}

	public void setSize(SizeEntity size) {
		this.size = size;
	}

	public BrandEntity getBrand() {
		return brand;
	}

	public void setBrand(BrandEntity brand) {
		this.brand = brand;
	}

	public RecommendAgeEntity getRecommend() {
		return recommend;
	}

	public void setRecommend(RecommendAgeEntity recommend) {
		this.recommend = recommend;
	}

}
