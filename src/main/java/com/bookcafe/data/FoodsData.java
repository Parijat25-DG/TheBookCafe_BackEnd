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
		product1.setProductId(101);
		product1.setName("Crepes");
		product1.setOrigin("France");
		product1.setDescription("Sweet");
		product1.setPrice("5");
		product1.setBrief("With Nutella and Banana");
		products.add(product1);
		
		Foods product2 = new Foods();
		product2.setProductId(102);
		product2.setName("Quiche");
		product2.setOrigin("France");
		product2.setDescription("Savoury");
		product2.setPrice("6");
		product2.setBrief("With Bacon and Cheese");
		products.add(product2);
		
		Foods product3 = new Foods();
		product3.setProductId(103);
		product3.setName("Waffles");
		product3.setOrigin("Belgium");
		product3.setDescription("Sweet");
		product3.setPrice("3");
		product3.setBrief("With Honey and Blueberries");
		products.add(product3);
		
		Foods product4 = new Foods();
		product4.setProductId(104);
		product4.setName("Pizza");
		product4.setOrigin("Italy");
		product4.setDescription("Savoury");
		product4.setPrice("5");
		product4.setBrief("With Ham and Tomatoes");
		products.add(product4);
		
		Foods product5 = new Foods();
		product5.setProductId(105);
		product5.setName("Tiramisu");
		product5.setOrigin("Italy");
		product5.setDescription("Sweet");
		product5.setPrice("4");
		product5.setBrief("With Coffee and Cream");
		products.add(product5);
		
		return products;
	}

}
