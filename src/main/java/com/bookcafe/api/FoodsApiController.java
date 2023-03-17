package com.bookcafe.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bookcafe.model.Foods;
import com.bookcafe.util.FoodsUtil;

@CrossOrigin("*")
@RestController
public class FoodsApiController {
	
	@Autowired
	private FoodsUtil foodsUtil;
	
	@GetMapping("/foods/getAllFoodProducts")
	public List<Foods> findAllFoodProducts(){
		return foodsUtil.retrieveAllFoodProducts();
	}
	
	@PostMapping("/foods/addFoodProduct")
	public String addFoodProduct(@RequestBody Foods foodProduct) {
		return "New Food Product added with ID : "+foodsUtil.addNewFoodProduct(foodProduct);
	}
	
	@PostMapping("/foods/removeFoodProduct")
	public String removeFoodProduct(@RequestBody Foods foodProduct) {
		foodsUtil.removeFoodProduct(foodProduct);
		return "Food Product with ID : "+foodProduct.getFoodId()+" deleted successfully";
	}
	
	@GetMapping("/foods/getFoodProducts")
	public List<Foods> findFoodsByCriteria(@RequestParam(value = "cuisine", required = false) String cuisine, 
			@RequestParam(value = "type", required = false) String type){
		return foodsUtil.findFoodsByCriteria(cuisine, type);
	}
	
	@GetMapping("/foods/getFoodsBySuitableTime/{time}")
	public List<Foods> findFoodsBySuitableTime(@PathVariable String time){
		return foodsUtil.findFoodsBySuitableTime(time);
	}
	
}
