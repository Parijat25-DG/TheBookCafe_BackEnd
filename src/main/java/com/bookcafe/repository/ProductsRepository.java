package com.bookcafe.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.bookcafe.model.Products;

@Repository
public interface ProductsRepository extends MongoRepository<Products, Integer>{

}
