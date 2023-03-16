package com.bookcafe.util;

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

	@Value("${current.env}")
	private String env;

	public int addNewBook(Books books) {
		Books savedBook = booksRepository.save(books);
		return savedBook.getBookId();
	}

	public void removeBook(Books book) {
		booksRepository.delete(booksRepository.findByBookId(book.getBookId()));
	}

	public List<Books> retrieveAllBooks() {
		if (env.equalsIgnoreCase("mock")) {
			return data.getData();
		} else {
			return booksRepository.findAll();
		}
	}

	public List<Books> findBooksByCriteria(String genre, String type, String language) {
		return booksRepository.findBooksByCriteria(genre, type, language);
	}
	
	public List<Books> findBooksByAuthor(String author) {
		return booksRepository.findByAuthor(author);
	}

}
