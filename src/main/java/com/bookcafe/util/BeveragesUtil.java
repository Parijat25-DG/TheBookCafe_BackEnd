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
	private BeveragesRepository itemsRepository;
	
	@Value( "${current.env}" )
	private String env;
	
	public int addNewItem(Beverages item) {
		Beverages savedItem = itemsRepository.save(item);
		return savedItem.getItemId();
	}
	
	public void removeItem(Beverages item) {
		itemsRepository.delete(item);
	}
	
	public List<Beverages> retriveAllItems() {
		if(env.equalsIgnoreCase("mock")) {
			return data.getData();
		} else {
			return itemsRepository.findAll();
		}
	}
	
}
