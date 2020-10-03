package com.wqueiroz.RestAPI.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wqueiroz.RestAPI.models.Product;
import com.wqueiroz.RestAPI.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	private ProductRepository repository;
	
	public ProductServiceImpl(ProductRepository repository) {
		this.repository = repository;
	}

	@Override
	public List<Product> findAll() {
		
		return this.repository.findAll();
	}


	@Override
	public Product update() {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public Product create(Product product) {
		this.repository.save(product);
		return product; 
	}

	@Override
	public Product find(Integer id) {
		// TODO Auto-generated method stub
		return this.repository.findById(id).orElse(null);
	}

	

	@Override 
	public void delete(Integer id) {
		Product  product = this.repository.findById(id).orElse(null);
		
		if (product !=null) this.repository.delete(product);
		
	}



}
