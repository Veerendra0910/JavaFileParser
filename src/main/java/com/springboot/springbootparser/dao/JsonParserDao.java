package com.springboot.springbootparser.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.springboot.springbootparser.entity.Book;
import com.springboot.springbootparser.repository.BookRepository;

@Component
public class JsonParserDao {

	@Autowired
	BookRepository bookRepository;
	
	public Boolean loadBooks(List<Book> listOfBooks) {
		Boolean success = Boolean.FALSE;
		if (!listOfBooks.isEmpty()) {
			for (Book book : listOfBooks) {
				bookRepository.save(book);
				success = Boolean.TRUE;
			}
		}
		return success;
	}

	public List<Book> getAllBooks() {
		return bookRepository.findAll();
	}
}
