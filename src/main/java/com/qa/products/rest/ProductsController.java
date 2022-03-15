package com.qa.products.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

}
