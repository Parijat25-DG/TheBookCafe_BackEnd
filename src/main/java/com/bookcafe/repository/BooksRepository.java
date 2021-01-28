package com.bookcafe.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.bookcafe.model.Books;

@Repository
public interface BooksRepository extends MongoRepository<Books, Integer>{
	

}
