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
		item1.setBeveragesId(201);
		item1.setName("Darjeeling Tea");
		item1.setQuality("Soothing");
		item1.setLactoseFree(false);
		item1.setPrice(3);
		item1.setTemperature("Digestive");
		item1.setSuitableTime("Evening");
		beverages.add(item1);
		
		Beverages item2 = new Beverages();
		item2.setBeveragesId(202);
		item2.setName("Cappucchino");
		item2.setQuality("Energizing");
		item2.setLactoseFree(false);
		item2.setPrice(2);
		item2.setTemperature("Maccaroon");
		item2.setSuitableTime("Morning");
		beverages.add(item2);
		
		Beverages item3 = new Beverages();
		item3.setBeveragesId(203);
		item3.setName("Hot Chocolate");
		item3.setQuality("Warming");
		item3.setLactoseFree(false);
		item3.setPrice(3);
		item3.setTemperature("Cookies");
		item3.setSuitableTime("Anytime");
		beverages.add(item3);

		Beverages item4 = new Beverages();
		item4.setBeveragesId(204);
		item4.setName("Espresso");
		item4.setQuality("Energizing");
		item4.setLactoseFree(true);
		item4.setPrice(2);
		item4.setTemperature("Medallion");
		item4.setSuitableTime("Morning");
		beverages.add(item4);
		
		Beverages item5 = new Beverages();
		item5.setBeveragesId(205);
		item5.setName("Earl Grey");
		item5.setQuality("Soothing");
		item5.setLactoseFree(true);
		item5.setPrice(3);
		item5.setTemperature("Biscuit");
		item5.setSuitableTime("Evening");
		beverages.add(item5);
		
		return beverages;
	}

}
