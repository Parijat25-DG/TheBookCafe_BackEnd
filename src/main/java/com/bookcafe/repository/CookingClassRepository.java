package com.bookcafe.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.bookcafe.model.CookingClass;

@Repository
public interface CookingClassRepository extends MongoRepository<CookingClass, Integer>{

}
