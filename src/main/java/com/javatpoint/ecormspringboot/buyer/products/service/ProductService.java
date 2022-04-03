package com.javatpoint.ecormspringboot.buyer.products.service;

import java.util.List;
import java.util.UUID;

import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.javatpoint.ecormspringboot.buyer.products.model.Product;
import com.javatpoint.ecormspringboot.buyer.products.repo.ProductRepo;


//@Service
//@Transactional
public class ProductService {
//	private final ProductRepo productRepo;
//
//	/**
//	 * @param productRepo
//	 */
//	@Autowired
//	public ProductService(ProductRepo productRepo) {
//		this.productRepo = productRepo;
//	}
//
//	public List<Product> findAllProducts() {
//		return productRepo.findAll();
//	}
//
//	public Product findProductById(Long id) {
//		return productRepo.findProductById(id).orElseThrow();
//
//	}
//
//	public Product addProduct(Product product) {
////		product.setEmployeeCode(UUID.randomUUID().toString());
//		return productRepo.save(product);
//	}
//
//	public Product updateProduct(Product product) {
//		return productRepo.save(product);
//	}
//
//	public void deleteProduct(Long id) {
//		productRepo.deleteProductById(id);
//	}
}
