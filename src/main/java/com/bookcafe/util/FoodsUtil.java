package com.bookcafe.util;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.bookcafe.data.FoodsData;
import com.bookcafe.model.Foods;
import com.bookcafe.repository.FoodsRepository;

@Component
public class FoodsUtil {
	
	@Autowired
	private FoodsData data;
	
	@Autowired
	private FoodsRepository productsRepository;
	
	@Value( "${current.env}" )
	private String env;
	
	public int addNewProduct(Foods product) {
		Foods savedProduct = productsRepository.save(product);
		return savedProduct.getProductId();
	}
	
	public void removeProduct(Foods product) {
		productsRepository.delete(product);
	}
	
	public List<Foods> retriveAllProducts() {
		if(env.equalsIgnoreCase("mock")) {
			return data.getData();
		} else {
			return productsRepository.findAll();
		}
	}

}
