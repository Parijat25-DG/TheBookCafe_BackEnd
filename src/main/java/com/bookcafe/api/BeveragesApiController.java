package com.bookcafe.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bookcafe.model.Beverages;
import com.bookcafe.util.BeveragesUtil;

@CrossOrigin("*")
@RestController
public class BeveragesApiController {
	
	@Autowired
	private BeveragesUtil beveragesUtil;
	
	@GetMapping("/getAllBeverages")
	public List<Beverages> findAllBeverages(){
		return beveragesUtil.retriveAllBeverages();
	}
	
	@PostMapping("/addBeverages")
	public String addBeverages(@RequestBody Beverages beverages) {
		return "New Beverages added with ID : "+beveragesUtil.addNewBeverages(beverages);
	}
	
	@PostMapping("/removeBeverages")
	public String removeBeverages(@RequestBody Beverages beverages) {
		beveragesUtil.removeBeverages(beverages);
		return "Beverages with ID : "+beverages.getBeveragesId()+" deleted successfully";
	}
	
}
