package com.qa.products.service;

import java.util.List;

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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Products readById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public Products update(Long id, Products y) {
		// TODO Auto-generated method stub
		return null;
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
