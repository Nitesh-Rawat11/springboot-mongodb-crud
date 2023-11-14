package com.springboot.javaguides.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.springboot.javaguides.model.Product;

public interface ProductRepository extends MongoRepository<Product, Long>{

}
