package com.bookcafe.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.bookcafe.model.Beverages;

@Repository
public interface BeveragesRepository extends MongoRepository<Beverages, Integer>{

	@Query("{ $and: [ { beveragesId: { $eq: ?0 } } ] }")
	Beverages findByBeverageId(int beverageId);

	@Query("{ $and: [ { suitabletime: { $eq: ?0 } }, { temperature: { $eq: ?1 } }, { lactoseFree: { $eq: ?2 } } ] }")
	List<Beverages> findBeveragesByCriteria(String suitableTime, String temperature, boolean lactoseFree);

	@Query("{ $and: [ { quality: { $eq: ?0 } } ] }")
	List<Beverages> findByQuality(String quality);

}
