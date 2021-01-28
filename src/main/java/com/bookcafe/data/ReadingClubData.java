package com.bookcafe.data;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.bookcafe.model.ReadingClub;

@Component
public class ReadingClubData {
	
	public List<ReadingClub> getData(){
		List<ReadingClub> clubList = new ArrayList<>();
		
		ReadingClub club1 = new ReadingClub();
		club1.setClubId(1001);
		club1.setBookName("The Hobbit");
		club1.setBookAuthor("JRR Tolkein");
		club1.setBookGenre("Fantasy");
		club1.setScheduledDate("04-02-2021");
		club1.setSeatsAvailable("15");
		club1.setSuitableFor("Kids");
		club1.setPrice("10");
		clubList.add(club1);
		
		ReadingClub club2 = new ReadingClub();
		club2.setClubId(1002);
		club2.setBookName("The Winds of Winter");
		club2.setBookAuthor("GRR Martin");
		club2.setBookGenre("Fantasy");
		club2.setScheduledDate("11-02-2021");
		club2.setSeatsAvailable("10");
		club2.setSuitableFor("Adults");
		club2.setPrice("15");
		clubList.add(club2);
		
		ReadingClub club3 = new ReadingClub();
		club3.setClubId(1003);
		club3.setBookName("The Jungle Book");
		club3.setBookAuthor("Rudyard Kipling");
		club3.setBookGenre("Adventure");
		club3.setScheduledDate("18-02-2021");
		club3.setSeatsAvailable("13");
		club3.setSuitableFor("Kids");
		club3.setPrice("10");
		clubList.add(club3);
		
		ReadingClub club4 = new ReadingClub();
		club4.setClubId(1004);
		club4.setBookName("Pride and Prejudice");
		club4.setBookAuthor("Jane Austen");
		club4.setBookGenre("Drama");
		club4.setScheduledDate("25-02-2021");
		club4.setSeatsAvailable("12");
		club4.setSuitableFor("Adults");
		club4.setPrice("15");
		clubList.add(club4);
		
		return clubList;
	}

}
