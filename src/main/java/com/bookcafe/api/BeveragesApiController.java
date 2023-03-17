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

import com.bookcafe.model.Beverages;
import com.bookcafe.util.BeveragesUtil;

@CrossOrigin("*")
@RestController
public class BeveragesApiController {
	
	@Autowired
	private BeveragesUtil beveragesUtil;
	
	@GetMapping("/beverages/getAllBeverages")
	public List<Beverages> findAllBeverages(){
		return beveragesUtil.retriveAllBeverages();
	}
	
	@PostMapping("/beverages/addBeverage")
	public String addBeverages(@RequestBody Beverages beverages) {
		return "New Beverages added with ID : "+beveragesUtil.addNewBeverages(beverages);
	}
	
	@PostMapping("/beverages/removeBeverage")
	public String removeBeverages(@RequestBody Beverages beverages) {
		beveragesUtil.removeBeverages(beverages);
		return "Beverages with ID : "+beverages.getBeveragesId()+" deleted successfully";
	}
	
	@GetMapping("/beverages/getBeverages")
	public List<Beverages> findBeveragesByCriteria(@RequestParam(value = "suitableTime", required = false) String suitableTime, 
			@RequestParam(value = "temperature", required = false) String temperature, @RequestParam(value = "lactoseFree", required = false) String lactoseFree){
		return beveragesUtil.findBeveragesByCriteria(suitableTime, temperature,Boolean.valueOf(lactoseFree));
	}
	
	@GetMapping("/beverages/getBeveragesByQuality/{quality}")
	public List<Beverages> findBeveragesByQuality(@PathVariable String quality) {
		return beveragesUtil.findBeveragesByQuality(quality);
	}
	
}
