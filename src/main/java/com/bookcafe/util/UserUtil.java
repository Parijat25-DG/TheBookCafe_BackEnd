package com.bookcafe.util;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;

import com.bookcafe.data.UserData;
import com.bookcafe.dto.Customer;
import com.bookcafe.model.User;
import com.bookcafe.repository.UserRepository;

@Component
public class UserUtil {
	
	@Autowired
	private UserData data;
	
	@Autowired
	private UserRepository userRepository;
	
	@Value( "${current.env}" )
	private String env;
	
	@Autowired
	private MongoTemplate mongoTemplate;
	
	public List<User> retriveAllUsers() {
		return data.getData();
	}
	
	public double addNewUser(User user) {
		if(user == null || (user != null && (user.getName() == null || user.getDob() == null || 
				user.getEmail() == null || user.getPhone() == null || user.getUsername() == null || user.getPassword() == null))) {
			return 0;
		}
		User newUser = userRepository.save(user);
		return newUser.getId();
	}
	
	public String loginUser(Customer customer) {
		if(customer.getUsername() != null && customer.getPassword() != null) {
			Query query = new Query();
			Criteria criteria = Criteria.where("username").is(customer.getUsername()).and("password").is(customer.getPassword());
			query.addCriteria(criteria);
			List<User> user = mongoTemplate.find(query, User.class);
			if(user != null && !user.isEmpty())
				return "You have logged in successfully";
		}
		return "Username/Password is incorrect";
	}

}
