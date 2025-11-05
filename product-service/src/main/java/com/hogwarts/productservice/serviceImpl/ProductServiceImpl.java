package com.hogwarts.productservice.serviceImpl;

import java.util.List;
import java.util.Optional;

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

@Service
public class ProductServiceImpl implements ProductService{
	
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private MongoTemplate mongoTemplate;
	

	@Override
	public Product addProduct(Product product) {
		
		return productRepository.save(product) ;
	}

	@Override
	public List<Product> getAllProduct() {
		
		return productRepository.findAll();
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
	public Optional<Product> getProductById(Long id) {
		return productRepository.findById(id);
	}

}
