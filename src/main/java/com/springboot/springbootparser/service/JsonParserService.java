package com.springboot.springbootparser.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.springboot.springbootparser.dao.JsonParserDao;
import com.springboot.springbootparser.entity.Book;
import com.springboot.springbootparser.parser.JsonParserExample;

@Service
public class JsonParserService {

	@Autowired
	JsonParserDao jsonParserDao;
	
	@Autowired
	JsonParserExample jsonParserExample;
	
	@Value("${json.file.path}")
	private String jsonFilePath;
	
	// Load Books by JsonParser
	public Boolean loadBooksByJsonParser() {
		return jsonParserDao.loadBooks(jsonParserExample.parseJson(jsonFilePath));
	}
	
	// Get All JSON Inserted Data
	public List<Book> getAllBooks(){
		return jsonParserDao.getAllBooks();
	}
}
