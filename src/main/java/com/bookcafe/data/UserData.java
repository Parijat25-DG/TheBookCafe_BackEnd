package com.bookcafe.data;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.bookcafe.model.User;

@Component
public class UserData {
	
	public List<User> getData() {
		List<User> users = new ArrayList<>();
		
		User user1 = new User();
		user1.setName("Leanne Graham");
		user1.setUsername("Bret");
		user1.setEmail("Sincere@april.biz");
		user1.setPhone("1-770-736-8031");
		user1.setDob("1988-10-25");
		users.add(user1);
		
		User user2 = new User();
		user2.setName("Clementine Bauch");
		user2.setUsername("Samantha");
		user2.setEmail("Nathan@yesenia.net");
		user2.setPhone("1-463-123-4447");
		user2.setDob("1990-01-17");
		users.add(user2);
		
		User user3 = new User();
		user3.setName("Ervin Howell");
		user3.setUsername("Antonette");
		user3.setEmail("Shanna@melissa.tv");
		user3.setPhone("010-692-6593");
		user3.setDob("1989-08-19");
		users.add(user3);
		
		return users;
	}

}
