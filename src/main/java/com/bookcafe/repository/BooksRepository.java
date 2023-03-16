package com.bookcafe.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.bookcafe.model.Books;

@Repository
public interface BooksRepository extends MongoRepository<Books, Integer>{
	
	 @Query("{ $and: [ { genre: { $eq: ?0 } }, { type: { $eq: ?1 } }, { languageCode: { $eq: ?2 } } ] }")
    List<Books> findBooksByCriteria( String genre,  String type,  int language);
	
}
