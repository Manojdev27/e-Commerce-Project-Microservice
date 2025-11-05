package com.hogwarts.productservice.service;

import java.util.List;
import java.util.Optional;

import com.hogwarts.productservice.entity.Product;

public interface ProductService {
	
	public Product addProduct(Product product);
	public List<Product> getAllProduct();
	public Optional<Product> getProductById(Long id);
	public long generateSequence(String seqName);

}
