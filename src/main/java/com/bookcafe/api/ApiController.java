package com.bookcafe.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bookcafe.dto.Cart;
import com.bookcafe.dto.Customer;
import com.bookcafe.dto.Selection;
import com.bookcafe.model.Books;
import com.bookcafe.model.Beverages;
import com.bookcafe.model.CookingClass;
import com.bookcafe.model.Foods;
import com.bookcafe.model.Query;
import com.bookcafe.model.ReadingClub;
import com.bookcafe.model.User;
import com.bookcafe.util.BookUtil;
import com.bookcafe.util.CartUtil;
import com.bookcafe.util.BeveragesUtil;
import com.bookcafe.util.CookingClassUtil;
import com.bookcafe.util.FoodsUtil;
import com.bookcafe.util.QueryUtil;
import com.bookcafe.util.ReadingClubUtil;
import com.bookcafe.util.SelectionUtil;
import com.bookcafe.util.UserUtil;

@CrossOrigin("*")
@RestController
public class ApiController {
	
	@Autowired
	private QueryUtil queryUtil;
	
	@Autowired
	private CartUtil cartUtil;
	
	@Autowired
	private SelectionUtil selectionUtil;
	
	@GetMapping("/removeEntry/{cartId}/{id}")
	public Selection retrieveCart(@PathVariable String cartId,@PathVariable String id){
		return selectionUtil.removeEntry(Integer.parseInt(cartId),Integer.parseInt(id));
	}
	
	@PostMapping("/submitOrder")
	public String submitOrder(@RequestBody Selection selection) {
		return selectionUtil.submitOrder(selection);
	}
	
	@GetMapping("/retrieveCart/{cartId}")
	public Selection retrieveCart(@PathVariable String cartId){
		return selectionUtil.retrieveCart(Integer.parseInt(cartId));
	}
	
	@PostMapping("/saveCart")
	public String saveCart(@RequestBody Cart cart) {
		return cartUtil.saveCart(cart);
	}
	
	@PostMapping("/saveQuery")
	public String saveQuery(@RequestBody Query query) {
		return queryUtil.saveQuery(query);
	}
	
}
