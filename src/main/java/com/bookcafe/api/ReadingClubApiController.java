package com.bookcafe.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bookcafe.model.ReadingClub;
import com.bookcafe.util.ReadingClubUtil;

@CrossOrigin("*")
@RestController
public class ReadingClubApiController {
	
	@Autowired
	private ReadingClubUtil readingClubUtil;
	
	@GetMapping("/getReadingClubs")
	public List<ReadingClub> findAllReadingClubs(){
		return readingClubUtil.retrieveReadingClubDetails();
	}
	
	@PostMapping("/addReadingClub")
	public String addReadingClub(@RequestBody ReadingClub clubs) {
		return "New Club added with ID : "+readingClubUtil.addNewReadingClub(clubs);
	}
	
	@PostMapping("/removeReadingClub")
	public String removeReadingClub(@RequestBody ReadingClub clubs) {
		readingClubUtil.removeReadingClub(clubs);
		return "Reading Club with ID : "+clubs.getClubId()+" deleted successfully";
	}
	
}
