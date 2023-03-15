package com.bookcafe.util;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.bookcafe.data.BookData;
import com.bookcafe.model.Books;
import com.bookcafe.repository.BooksRepository;

@Component
public class BookUtil {
	
	@Autowired
	private BookData data;
	
	@Autowired
	private BooksRepository booksRepository;
	
	@Value( "${current.env}" )
	private String env;
	
	public List<Integer> addNewBook(List<Books> books) {
		List<Integer> savedBooks = new ArrayList<>();
		books.forEach(book ->{
			Books savedBook = booksRepository.save(book);
			savedBooks.add(savedBook.getBookId());
		});
		
		return savedBooks;
	}
	
	public void removeBook(Books book) {
		booksRepository.delete(book);
	}
	
	public List<Books> retriveAllBooks() {
		if(env.equalsIgnoreCase("mock")) {
			return data.getData();
		} else {
			return booksRepository.findAll();
		}
	}
	
}
