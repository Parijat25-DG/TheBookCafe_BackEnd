package com.bookcafe.util;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.bookcafe.data.BeveragesData;
import com.bookcafe.model.Beverages;
import com.bookcafe.repository.BeveragesRepository;

@Component
public class BeveragesUtil {
	
	@Autowired
	private BeveragesData data;
	
	@Autowired
	private BeveragesRepository beveragesRepository;
	
	@Value( "${current.env}" )
	private String env;
	
	public int addNewBeverages(Beverages beverages) {
		Beverages savedBeverages = beveragesRepository.save(beverages);
		return savedBeverages.getBeveragesId();
	}
	
	public void removeBeverages(Beverages beverages) {
		beveragesRepository.delete(beverages);
	}
	
	public List<Beverages> retriveAllBeverages() {
		if(env.equalsIgnoreCase("mock")) {
			return data.getData();
		} else {
			return beveragesRepository.findAll();
		}
	}
	
}
