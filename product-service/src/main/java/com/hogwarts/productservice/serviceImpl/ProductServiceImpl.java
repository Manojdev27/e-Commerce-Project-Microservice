package com.hogwarts.productservice.serviceImpl;

import java.util.List;
import java.util.Optional;

import javax.management.RuntimeErrorException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.FindAndModifyOptions;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import com.hogwarts.productservice.entity.Counter;
import com.hogwarts.productservice.entity.Product;
import com.hogwarts.productservice.repository.ProductRepository;
import com.hogwarts.productservice.service.ProductService;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@Service
public class ProductServiceImpl implements ProductService{
	
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private MongoTemplate mongoTemplate;
	
	private static final String FALLBACK_METHOD = "fallbackMethod";
	

	@Override
	public Product addProduct(Product product) {
		
		return productRepository.save(product) ;
	}

	@Override
	public List<Product> getAllProduct() {
		List<Product> productList = productRepository.findAll();
		if(productList.isEmpty()) {
			throw new RuntimeException("No Product Available");
		}
		return productList;
	}

	@Override
	public long generateSequence(String seqName) {
		Counter counter = mongoTemplate.findAndModify(
				org.springframework.data.mongodb.core.query.Query.query(Criteria.where("id").is(seqName)),
				new Update().inc("seq", 1), FindAndModifyOptions.options().returnNew(true).upsert(true),
				Counter.class);
		return counter != null ? counter.getSeq() : 1;
	}

	@Override
	@CircuitBreaker(name =FALLBACK_METHOD,fallbackMethod = "fallBackResponse")
	public Optional<Product> getProductById(Long id) {
		Optional<Product> product = productRepository.findById(id);
		if(product.isEmpty()) {
			throw new RuntimeException("Service Failed");
		}
		return product;
	}

	public String fallBackResponse(Exception e) {
		return "FallBack Response: "+e.getMessage();
	}
}
