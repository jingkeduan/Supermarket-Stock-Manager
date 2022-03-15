package com.qa.products.service;

import java.util.List;
import java.util.Optional;

import com.qa.products.domain.Products;
import com.qa.products.repo.ProductsRepo;

public class ProductsServiceDB implements ProductsInterface{

	private ProductsRepo repo;
	
	@Override
	public Products create(Products x) {
		return this.repo.save(x);
		
	}

	@Override
	public List<Products> readAll() {
		return this.repo.findAll();
	}

	@Override
	public Products readById(Long id) {
		return this.repo.findById(id).orElse(null);
	}
	
	@Override
	public Products update(Long id, Products y) {
		Optional<Products>a=this.repo.findById(id);
		if (a.isPresent()) {
		Products newItem=new Products();
		newItem.setCategory(y.getCategory());
		newItem.setId(id);
		newItem.setName(y.getName());
		newItem.setPrice(y.getPrice());
		newItem.setQuantity(y.getQuantity());
		return this.repo.save(newItem);
		}
		else {
			return null;
		}
	}

	@Override
	public boolean delete(Long id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Products remove(Long id) {
		// TODO Auto-generated method stub
		return null;
	}



}
