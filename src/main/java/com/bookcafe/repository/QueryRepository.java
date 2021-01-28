package com.bookcafe.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.bookcafe.model.Query;

@Repository
public interface QueryRepository extends MongoRepository<Query, Integer>{
	

}
