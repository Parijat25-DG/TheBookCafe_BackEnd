package com.bookcafe.data;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.bookcafe.model.CookingClass;

@Component
public class CookingClassData {
	
	public List<CookingClass> getData(){
		List<CookingClass> classList = new ArrayList<>();
		
		CookingClass class1 = new CookingClass();
		class1.setClassId(2001);
		class1.setRecipeName("Chocolate Walnut Brownies");
		class1.setRecipeType("Sweet");
		class1.setScheduledDate("05-02-2021");
		class1.setSeatsAvailable("15");
		class1.setSuitableFor("Kids");
		class1.setPrice("10");
		classList.add(class1);
		
		CookingClass class2 = new CookingClass();
		class2.setClassId(2002);
		class2.setRecipeName("Carrot Cake with Cream Cheese Frosting");
		class2.setRecipeType("Sweet");
		class2.setScheduledDate("12-02-2021");
		class2.setSeatsAvailable("10");
		class2.setSuitableFor("Adults");
		class2.setPrice("15");
		classList.add(class2);
		
		CookingClass class3 = new CookingClass();
		class3.setClassId(2003);
		class3.setRecipeName("Tricolor Noodles");
		class3.setRecipeType("Savoury");
		class3.setScheduledDate("19-02-2021");
		class3.setSeatsAvailable("13");
		class3.setSuitableFor("Kids");
		class3.setPrice("10");
		classList.add(class3);
		
		CookingClass class4 = new CookingClass();
		class4.setClassId(2004);
		class4.setRecipeName("Handmade Pasta Bolognese");
		class4.setRecipeType("Savoury");
		class4.setScheduledDate("26-02-2021");
		class4.setSeatsAvailable("12");
		class4.setSuitableFor("Adults");
		class4.setPrice("15");
		classList.add(class4);
		
		return classList;
	}

}
