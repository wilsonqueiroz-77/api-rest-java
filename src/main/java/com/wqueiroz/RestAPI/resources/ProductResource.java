package com.wqueiroz.RestAPI.resources;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.wqueiroz.RestAPI.models.Product;
import com.wqueiroz.RestAPI.services.ProductService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/products")
@Api(value = "API Rest - Model Product")
public class ProductResource {
	
	@Autowired
	private ProductService productService;
	
	public ProductResource(ProductService productService) {
		this.productService = productService;
	}


	@ApiOperation(value = "Find all products")
	@GetMapping(produces = "application/json")
	@ResponseBody
	public List<Product> findAll(){
		return this.productService.findAll();
	}
	
	@ApiOperation(value = "Find by id products")
	@GetMapping(value = "/{id}")
	@ResponseBody
	public Product find(@PathVariable(value = "id") Integer id) {
		
		return this.productService.find(id);
	}
	@ApiOperation(value = "Create Products")
	@PostMapping
	@ResponseBody
	@ResponseStatus(code = HttpStatus.CREATED)
	public Product create(@RequestBody Product product) {
		return this.productService.create(product);
	}
	
	@ApiOperation(value = "Update Products")
	@PutMapping(value = "/{id}")
	@ResponseBody
	@ResponseStatus(code = HttpStatus.OK)
	public Product update(@PathVariable(value = "id")Integer id,@RequestBody Product product) {
		
		return null;
	}
	@ApiOperation(value = "Delete Products")
	@DeleteMapping(value = "/{id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void delete(@PathVariable(value="id") Integer id, HttpServletResponse response) {
		
		this.productService.delete(id);
		
		response.setStatus(HttpServletResponse.SC_NO_CONTENT);
		
	}
	
	
	

}
