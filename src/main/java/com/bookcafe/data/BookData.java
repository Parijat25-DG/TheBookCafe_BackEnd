package com.bookcafe.data;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.bookcafe.model.Books;

@Component
public class BookData {
	
	public List<Books> getData() {
		List<Books> books = new ArrayList<>();
		
		Books book1 = new Books();
		book1.setBookId(301);
		book1.setName("Harry Potter");
		book1.setAuthor("JK Rowling");
		book1.setGenre("Fantasy");
		book1.setPrice("50");
		book1.setType("Series");
		book1.setLanguageCode(1);
		books.add(book1);
		
		Books book2 = new Books();
		book2.setBookId(302);
		book2.setName("Lord of the Rings");
		book2.setAuthor("JRR Tolkein");
		book2.setGenre("Fantasy");
		book2.setPrice("60");
		book2.setType("Series");
		book2.setLanguageCode(1);
		books.add(book2);
		
		Books book3 = new Books();
		book3.setBookId(303);
		book3.setName("Tell Me your Dreams");
		book3.setAuthor("Sidney Sheldon");
		book3.setGenre("Thriller");
		book3.setPrice("40");
		book3.setType("Novel");
		book3.setLanguageCode(1);
		books.add(book3);
		
		Books book4 = new Books();
		book4.setBookId(304);
		book4.setName("Les Misérables");
		book4.setAuthor("Victor Hugo");
		book4.setGenre("Drama");
		book4.setPrice("30");
		book4.setType("Novel");
		book4.setLanguageCode(2);
		books.add(book4);
		
		Books book5 = new Books();
		book5.setBookId(305);
		book5.setName("Don Quixote");
		book5.setAuthor("Miguel de Cervantes");
		book5.setGenre("Satire");
		book5.setPrice("25");
		book5.setType("Novel");
		book5.setLanguageCode(3);
		books.add(book5);
		
		return books;
	}

}
