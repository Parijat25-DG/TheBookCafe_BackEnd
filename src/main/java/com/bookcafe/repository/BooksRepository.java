package com.bookcafe.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.bookcafe.model.Books;

@Repository
public interface BooksRepository extends MongoRepository<Books, Integer> {

	@Query("{ $and: [ { genre: { $eq: ?0 } }, { type: { $eq: ?1 } }, { language: { $eq: ?2 } } ] }")
	List<Books> findBooksByCriteria(String genre, String type, String language);

	@Query("{'bookId': ?0}")
	void deleteByBookId(int bookId);
	
	@Query("{ $and: [ { bookId: { $eq: ?0 } } ] }")
	Books findByBookId(int bookId);
	
	@Query("{ $and: [ { author: { $eq: ?0 } } ] }")
	List<Books> findByAuthor(String author);

}
