package com.bookcafe.util;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.bookcafe.data.FoodsData;
import com.bookcafe.model.Foods;
import com.bookcafe.repository.FoodsRepository;

@Component
public class FoodsUtil {
	
	@Autowired
	private FoodsData data;
	
	@Autowired
	private FoodsRepository foodsRepository;
	
	@Value( "${current.env}" )
	private String env;
	
	public void removeFoodProduct(Foods foodProduct) {
		foodsRepository.delete(foodsRepository.findByFoodId(foodProduct.getFoodId()));
	}
	
	public List<Foods> retrieveAllFoodProducts() {
		if(env.equalsIgnoreCase("mock")) {
			return data.getData();
		} else {
			return foodsRepository.findAll();
		}
	}

	public int addNewFoodProduct(Foods foodProduct) {
		return foodsRepository.save(foodProduct).getFoodId();
	}
	
	public List<Foods> findFoodsByCriteria(String cuisine, String type) {
		return foodsRepository.findFoodsByCriteria(cuisine, type);
	}

	public List<Foods> findFoodsBySuitableTime(String time) {
		return foodsRepository.findBySuitableTime(time);
	}

}
