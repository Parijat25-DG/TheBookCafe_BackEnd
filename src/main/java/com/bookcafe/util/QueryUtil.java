package com.bookcafe.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bookcafe.model.Query;
import com.bookcafe.repository.QueryRepository;

@Component
public class QueryUtil {
	
	@Autowired
	private QueryRepository queryRepository;
	
	public String saveQuery(Query query) {
		if(query != null && query.getSubject() != null && query.getDetails() != null) {
			Query savedQuery = queryRepository.save(query);
			return "Your query is saved with Id : "+ savedQuery.getId()+ " We will get back to you 2 working days";
		}
		return "Something went wrong";
	}

}
