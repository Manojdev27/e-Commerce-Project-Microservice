package com.hogwarts.productservice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.hogwarts.productservice.entity.Product;

@Repository
public interface ProductRepository extends MongoRepository<Product, Long>{

}
