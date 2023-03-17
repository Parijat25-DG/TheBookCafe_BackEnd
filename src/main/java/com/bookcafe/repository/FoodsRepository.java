package com.bookcafe.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.bookcafe.model.Foods;

@Repository
public interface FoodsRepository extends MongoRepository<Foods, Integer>{
	
	@Query("{ $and: [ { cuisine: { $eq: ?0 } }, { type: { $eq: ?1 } } ] }")
	List<Foods> findFoodsByCriteria(String cuisine, String type);
	
	@Query("{ $and: [ { foodId: { $eq: ?0 } } ] }")
	Foods findByFoodId(int foodId);

	@Query("{ $and: [ { suitabletime: { $eq: ?0 } } ] }")
	List<Foods> findBySuitableTime(String time);

}
