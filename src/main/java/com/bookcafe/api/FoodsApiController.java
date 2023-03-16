package com.bookcafe.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bookcafe.model.Foods;
import com.bookcafe.util.FoodsUtil;

@CrossOrigin("*")
@RestController
public class FoodsApiController {
	
	@Autowired
	private FoodsUtil productUtil;
	
	@GetMapping("/getAllProducts")
	public List<Foods> findAllProducts(){
		return productUtil.retriveAllProducts();
	}
	
	@PostMapping("/addProduct")
	public String addProduct(@RequestBody Foods product) {
		return "New Product added with ID : "+productUtil.addNewProduct(product);
	}
	
	@PostMapping("/removeProduct")
	public String removeProduct(@RequestBody Foods product) {
		productUtil.removeProduct(product);
		return "Product with ID : "+product.getFoodId()+" deleted successfully";
	}
	
}
