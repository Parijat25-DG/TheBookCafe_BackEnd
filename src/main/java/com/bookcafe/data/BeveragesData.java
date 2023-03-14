package com.bookcafe.data;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.bookcafe.model.Beverages;

@Component
public class BeveragesData {
	
	public List<Beverages> getData() {
		List<Beverages> beverages = new ArrayList<>();
		
		Beverages item1 = new Beverages();
		item1.setItemId(201);
		item1.setName("Darjeeling Tea");
		item1.setQuality("Soothing");
		item1.setDescription("Liquor Blend without Milk");
		item1.setPrice("3");
		item1.setAccompaniments("Digestive");
		item1.setTime("Evening");
		beverages.add(item1);
		
		Beverages item2 = new Beverages();
		item2.setItemId(202);
		item2.setName("Cappucchino");
		item2.setQuality("Energizing");
		item2.setDescription("Milk/Cream Blend");
		item2.setPrice("2");
		item2.setAccompaniments("Maccaroon");
		item2.setTime("Morning");
		beverages.add(item2);
		
		Beverages item3 = new Beverages();
		item3.setItemId(203);
		item3.setName("Hot Chocolate");
		item3.setQuality("Warming");
		item3.setDescription("Stirred Heavy Cream");
		item3.setPrice("3");
		item3.setAccompaniments("Cookies");
		item3.setTime("Anytime");
		beverages.add(item3);

		Beverages item4 = new Beverages();
		item4.setItemId(204);
		item4.setName("Espresso");
		item4.setQuality("Energizing");
		item4.setDescription("Intense Liquor Blend");
		item4.setPrice("2");
		item4.setAccompaniments("Medallion");
		item4.setTime("Morning");
		beverages.add(item4);
		
		Beverages item5 = new Beverages();
		item5.setItemId(205);
		item5.setName("Earl Grey");
		item5.setQuality("Soothing");
		item5.setDescription("Liquor Blend without Milk");
		item5.setPrice("3");
		item5.setAccompaniments("Biscuit");
		item5.setTime("Evening");
		beverages.add(item5);
		
		return beverages;
	}

}
