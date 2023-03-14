package com.bookcafe.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bookcafe.model.Books;
import com.bookcafe.util.BookUtil;

@CrossOrigin("*")
@RestController
public class BooksApiController {
	
	@Autowired
	private BookUtil bookUtil;
	
	@GetMapping("/getAllBooks")
	public List<Books> findAllBooks(){
		return bookUtil.retriveAllBooks();
	}
	
	@PostMapping("/addBook")
	public String addBook(@RequestBody Books book) {
		return "New Book added with ID : "+bookUtil.addNewBook(book);
	}
	
	@PostMapping("/removeBook")
	public String removeBook(@RequestBody Books book) {
		bookUtil.removeBook(book);
		return "Book with ID : "+book.getBookId()+" deleted successfully";
	}
	
}
