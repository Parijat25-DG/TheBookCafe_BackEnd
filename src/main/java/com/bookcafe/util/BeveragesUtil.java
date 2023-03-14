package com.bookcafe.util;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.bookcafe.data.ItemData;
import com.bookcafe.model.Items;
import com.bookcafe.repository.ItemsRepository;

@Component
public class ItemUtil {
	
	@Autowired
	private ItemData data;
	
	@Autowired
	private ItemsRepository itemsRepository;
	
	@Value( "${current.env}" )
	private String env;
	
	public int addNewItem(Items item) {
		Items savedItem = itemsRepository.save(item);
		return savedItem.getItemId();
	}
	
	public void removeItem(Items item) {
		itemsRepository.delete(item);
	}
	
	public List<Items> retriveAllItems() {
		if(env.equalsIgnoreCase("mock")) {
			return data.getData();
		} else {
			return itemsRepository.findAll();
		}
	}
	
}
