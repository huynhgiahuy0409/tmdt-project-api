package com.javatpoint.ecormspringboot.buyer.products.resource;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.javatpoint.ecormspringboot.buyer.products.model.Product;
import com.javatpoint.ecormspringboot.buyer.products.service.ProductService;

//@RestController
//@RequestMapping("/product")
public class ProductResource {
//	private final ProductService productService;
//
//	/**
//	 * @param productService
//	 */
//	public ProductResource(ProductService productService) {
//		super();
//		this.productService = productService;
//	}
//
//	@GetMapping("/all")
//	public ResponseEntity<List<Product>> getAllProducts() {
//		List<Product> product = productService.findAllProducts();
//		return new ResponseEntity<>(product, HttpStatus.OK);
//	}
//
//	@GetMapping("/find/{id}")
//	public ResponseEntity<Product> getProductById(@PathVariable("id") Long id) {
//		Product product = productService.findProductById(id);
//		return new ResponseEntity<>(product, HttpStatus.OK);
//	}
//
//	@PostMapping("/add")
//	public ResponseEntity<Product> addEmployee(@RequestBody Product product) {
//		Product newProduct = productService.addProduct(product);
//		return new ResponseEntity<>(newProduct, HttpStatus.CREATED);
//	}
//	
//    @PutMapping("/update")
//    public ResponseEntity<Product> updateProduct(@RequestBody Product product) {
//        Product updateProduct = productService.updateProduct(product);
//        return new ResponseEntity<>(updateProduct, HttpStatus.OK);
//    }
//	
//	@DeleteMapping("/delete/{id}")
//    public ResponseEntity<Product> deleteProduct(@PathVariable("id") Long id) {
//         productService.deleteProduct(id);
//        return new ResponseEntity<>(HttpStatus.OK);
//    }
}
