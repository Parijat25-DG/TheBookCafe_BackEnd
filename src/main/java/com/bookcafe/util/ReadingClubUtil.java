package com.bookcafe.util;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.bookcafe.data.ReadingClubData;
import com.bookcafe.model.ReadingClub;
import com.bookcafe.repository.ReadingclubRepository;

@Component
public class ReadingClubUtil {
	
	@Autowired
	private ReadingClubData data;
	
	@Autowired
	private ReadingclubRepository readingclubRepository;
	
	@Value( "${current.env}" )
	private String env;
	
	public int addNewReadingClub(ReadingClub readingClub) {
		ReadingClub savedProduct = readingclubRepository.save(readingClub);
		return savedProduct.getClubId();
	}
	
	public void removeReadingClub(ReadingClub readingClub) {
		readingclubRepository.delete(readingClub);
	}
	
	public List<ReadingClub> retrieveReadingClubDetails() {
		if(env.equalsIgnoreCase("mock")) {
			return data.getData();
		} else {
			return readingclubRepository.findAll();
		}
	}

}
