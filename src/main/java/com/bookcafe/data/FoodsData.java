package com.bookcafe.data;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.bookcafe.model.Foods;

@Component
public class FoodsData {
	
	public List<Foods> getData() {
		List<Foods> products = new ArrayList<>();
		
		Foods product1 = new Foods();
		product1.setFoodId(101);
		product1.setName("Crepes");
		product1.setCuisine("France");
		product1.setType("Sweet");
		product1.setPrice(5);
		product1.setDescription("With Nutella and Banana");
		products.add(product1);
		
		Foods product2 = new Foods();
		product2.setFoodId(102);
		product2.setName("Quiche");
		product2.setCuisine("France");
		product2.setType("Savoury");
		product2.setPrice(6);
		product2.setDescription("With Bacon and Cheese");
		products.add(product2);
		
		Foods product3 = new Foods();
		product3.setFoodId(103);
		product3.setName("Waffles");
		product3.setCuisine("Belgium");
		product3.setType("Sweet");
		product3.setPrice(3);
		product3.setDescription("With Honey and Blueberries");
		products.add(product3);
		
		Foods product4 = new Foods();
		product4.setFoodId(104);
		product4.setName("Pizza");
		product4.setCuisine("Italy");
		product4.setType("Savoury");
		product4.setPrice(5);
		product4.setDescription("With Ham and Tomatoes");
		products.add(product4);
		
		Foods product5 = new Foods();
		product5.setFoodId(105);
		product5.setName("Tiramisu");
		product5.setCuisine("Italy");
		product5.setType("Sweet");
		product5.setPrice(4);
		product5.setDescription("With Coffee and Cream");
		products.add(product5);
		
		return products;
	}

}
