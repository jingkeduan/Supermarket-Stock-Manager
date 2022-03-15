package com.qa.products.rest;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.qa.products.domain.Products;
import com.qa.products.service.ProductsServiceDB;

@RestController
public class ProductsController{
	
	private ProductsServiceDB service;

	public ProductsController(ProductsServiceDB service) {
		super();
		this.service=service;
	}
	
	@PostMapping("/create")
	public ResponseEntity<Products> createProduct(@RequestBody Products a){
		return new ResponseEntity<Products>(this.service.create(a),HttpStatus.CREATED);
	}
	
	@GetMapping("/readAll")
	public List<Products> readAllProducts(){
		return this.service.readAll();
	}
	
	@GetMapping("/readById/{id}")
	public Products readById(@PathVariable Long id) {
		return this.service.readById(id);
	}

}
