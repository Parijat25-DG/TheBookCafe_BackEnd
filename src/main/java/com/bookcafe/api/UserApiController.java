package com.bookcafe.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bookcafe.dto.Customer;
import com.bookcafe.model.User;
import com.bookcafe.util.UserUtil;

@CrossOrigin("*")
@RestController
public class UserApiController {
	
	@Autowired
	private UserUtil userUtil;
	
	@PostMapping("/loginUser")
	public String loginUser(@RequestBody Customer customer) {
		return userUtil.loginUser(customer);
	}
	
	@PostMapping("/registerUser")
	public String registerUser(@RequestBody User user) {
		double newUser = userUtil.addNewUser(user);
		if(newUser == 0) {
			return "Please enter valid details";
		} else {
			return "You have registered successfully with user ID : "+newUser;
		}
	}
	
	@GetMapping("/getAllUsers")
	public List<User> findAllUsers(){
		return userUtil.retriveAllUsers();
	}

}
