package com.wqueiroz.RestAPI.services;

import java.util.List;

import com.wqueiroz.RestAPI.models.Product;

public interface ProductService {
	
	public List <Product>findAll();
	public Product find(Integer id);
	public Product create(Product product);
	public Product update();
	public void delete(Integer id);
	

}
