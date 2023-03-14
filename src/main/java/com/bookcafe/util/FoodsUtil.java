package com.bookcafe.util;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.bookcafe.data.ProductData;
import com.bookcafe.model.Products;
import com.bookcafe.repository.ProductsRepository;

@Component
public class ProductUtil {
	
	@Autowired
	private ProductData data;
	
	@Autowired
	private ProductsRepository productsRepository;
	
	@Value( "${current.env}" )
	private String env;
	
	public int addNewProduct(Products product) {
		Products savedProduct = productsRepository.save(product);
		return savedProduct.getProductId();
	}
	
	public void removeProduct(Products product) {
		productsRepository.delete(product);
	}
	
	public List<Products> retriveAllProducts() {
		if(env.equalsIgnoreCase("mock")) {
			return data.getData();
		} else {
			return productsRepository.findAll();
		}
	}

}
