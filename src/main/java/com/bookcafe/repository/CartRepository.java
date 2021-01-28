package com.bookcafe.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.bookcafe.model.SavedCart;

@Repository
public interface CartRepository extends MongoRepository<SavedCart, Integer>{
	

}
