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
	private BeveragesUtil itemUtil;
	
	@GetMapping("/getAllItems")
	public List<Beverages> findAllItems(){
		return itemUtil.retriveAllItems();
	}
	
	@PostMapping("/addItem")
	public String addItem(@RequestBody Beverages item) {
		return "New Item added with ID : "+itemUtil.addNewItem(item);
	}
	
	@PostMapping("/removeItem")
	public String removeItem(@RequestBody Beverages item) {
		itemUtil.removeItem(item);
		return "Item with ID : "+item.getItemId()+" deleted successfully";
	}
	
}
