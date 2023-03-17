package com.bookcafe.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bookcafe.model.Books;
import com.bookcafe.util.BookUtil;

@CrossOrigin("*")
@RestController
public class BooksApiController {

	@Autowired
	private BookUtil bookUtil;

	@GetMapping("/books/getAllBooks")
	public List<Books> findAllBooks() {
		return bookUtil.retrieveAllBooks();
	}

	@PostMapping("/books/addBook")
	public String addBook(@RequestBody Books books) {
		return "New Book added with ID : " + bookUtil.addNewBook(books);
	}

	@PostMapping("/books/removeBook")
	public String removeBook(@RequestBody Books book) {
		bookUtil.removeBook(book);
		return "Book with ID : " + book.getBookId() + " deleted successfully";
	}

	@GetMapping("/books/getBooks")
	public List<Books> findBooksByCriteria(@RequestParam(value = "genre", required = false) String genre,
			@RequestParam(value = "type", required = false) String type,
			@RequestParam(value = "language", required = false) String language) {
		return bookUtil.findBooksByCriteria(genre, type, language);
	}

	@GetMapping("/books/getBooksByAuthor/{author}")
	public List<Books> findBooksByAuthor(@PathVariable String author) {
		return bookUtil.findBooksByAuthor(author);
	}

}
