package com.springboot.javaguides.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

import com.springboot.javaguides.model.Product;
import com.springboot.javaguides.service.ProductService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("api")
@Tag(name = "Product Controller All CRUD API", description = "this is the class that implements all the CRUD api related to "
		+ "products management")
public class ProductController {

	@Autowired
	private ProductService productService;
	
	@PostMapping("/products")
	public ResponseEntity<Product> createProduct(@RequestBody Product product){
		return ResponseEntity.ok().body(this.productService.createProduct(product));
	}
	
	@GetMapping("/products")
	@Operation(summary = "finding all products from db ", description = "getting all products from db using this api")
	@ApiResponse(responseCode = "200", description = "HTTP status 200 OK")
	public ResponseEntity<List<Product>> getAllProduct(){
		return ResponseEntity.ok().body(productService.getAllProduct());
	}
	
	@GetMapping("/products/{id}")
	public ResponseEntity<Product> getProductById(@PathVariable long id){
		return ResponseEntity.ok().body(productService.getProductById(id));
	}
	
	@PutMapping("/products/{id}")
	public ResponseEntity<Product> updateProduct(@PathVariable long id, @RequestBody Product product){
		product.setId(id);
		return ResponseEntity.ok().body(this.productService.updateProduct(product));
	}

	@DeleteMapping("/products/{id}")
	public HttpStatus deleteProduct(@PathVariable long id){
		this.productService.deleteProduct(id);
		return HttpStatus.OK;
	}
}
