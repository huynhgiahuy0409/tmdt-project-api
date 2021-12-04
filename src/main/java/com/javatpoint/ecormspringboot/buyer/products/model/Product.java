package com.javatpoint.ecormspringboot.buyer.products.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class Product implements Serializable{
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
	private Long id;
	private String name;
	private String imageUrl;
	private double price;
	private double sale;
	@Column(nullable = false, updatable = false)
	private int quantity;
	/**
	 * @param id
	 * @param name
	 * @param imageUrl
	 * @param price
	 * @param sale
	 * @param quantity
	 */
	public Product() {}
	public Product(Long id, String name, String imageUrl, double price, double sale, int quantity) {
		super();
		this.id = id;
		this.name = name;
		this.imageUrl = imageUrl;
		this.price = price;
		this.sale = sale;
		this.quantity = quantity;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public double getSale() {
		return sale;
	}
	public void setSale(double sale) {
		this.sale = sale;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", imageUrl=" + imageUrl + ", price=" + price + ", sale=" + sale
				+ ", quantity=" + quantity + "]";
	}
	
	
}
