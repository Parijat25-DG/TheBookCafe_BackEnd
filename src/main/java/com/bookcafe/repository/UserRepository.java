package com.bookcafe.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.bookcafe.model.User;

@Repository
public interface UserRepository extends MongoRepository<User, Integer>{

}
