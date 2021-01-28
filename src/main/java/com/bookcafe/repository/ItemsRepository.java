package com.bookcafe.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.bookcafe.model.Items;

@Repository
public interface ItemsRepository extends MongoRepository<Items, Integer>{

}
