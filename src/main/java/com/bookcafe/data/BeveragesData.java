package com.bookcafe.data;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.bookcafe.model.Items;

@Component
public class ItemData {
	
	public List<Items> getData() {
		List<Items> items = new ArrayList<>();
		
		Items item1 = new Items();
		item1.setItemId(201);
		item1.setName("Darjeeling Tea");
		item1.setQuality("Soothing");
		item1.setDescription("Liquor Blend without Milk");
		item1.setPrice("3");
		item1.setAccompaniments("Digestive");
		item1.setTime("Evening");
		items.add(item1);
		
		Items item2 = new Items();
		item2.setItemId(202);
		item2.setName("Cappucchino");
		item2.setQuality("Energizing");
		item2.setDescription("Milk/Cream Blend");
		item2.setPrice("2");
		item2.setAccompaniments("Maccaroon");
		item2.setTime("Morning");
		items.add(item2);
		
		Items item3 = new Items();
		item3.setItemId(203);
		item3.setName("Hot Chocolate");
		item3.setQuality("Warming");
		item3.setDescription("Stirred Heavy Cream");
		item3.setPrice("3");
		item3.setAccompaniments("Cookies");
		item3.setTime("Anytime");
		items.add(item3);

		Items item4 = new Items();
		item4.setItemId(204);
		item4.setName("Espresso");
		item4.setQuality("Energizing");
		item4.setDescription("Intense Liquor Blend");
		item4.setPrice("2");
		item4.setAccompaniments("Medallion");
		item4.setTime("Morning");
		items.add(item4);
		
		Items item5 = new Items();
		item5.setItemId(205);
		item5.setName("Earl Grey");
		item5.setQuality("Soothing");
		item5.setDescription("Liquor Blend without Milk");
		item5.setPrice("3");
		item5.setAccompaniments("Biscuit");
		item5.setTime("Evening");
		items.add(item5);
		
		return items;
	}

}
