package com.springboot.springbootparser.parser;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.springboot.springbootparser.entity.Book;

@Component
public class JsonParserExample {

	public List<Book> parseJson(String jsonFilePath) {

		List<Book> books = new ArrayList<>();
		ObjectMapper objectMapper = new ObjectMapper();
		File booksJsonfile = new File(jsonFilePath);
		try {
			books = objectMapper.readValue(booksJsonfile, new TypeReference<List<Book>>() {
			});
		} catch (IOException e) {
			e.printStackTrace();
		}
		return books;
	}
}
