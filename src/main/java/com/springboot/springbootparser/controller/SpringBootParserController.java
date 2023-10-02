package com.springboot.springbootparser.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.springbootparser.dto.BaseResponse;
import com.springboot.springbootparser.entity.Book;
import com.springboot.springbootparser.entity.Customer;
import com.springboot.springbootparser.entity.Person;
import com.springboot.springbootparser.service.CsvParserService;
import com.springboot.springbootparser.service.JsonParserService;
import com.springboot.springbootparser.service.XmlParserService;

@RestController
@RequestMapping("/springboot")
public class SpringBootParserController {

	@Autowired
	XmlParserService xmlParserService;

	@Autowired
	CsvParserService csvParserService;

	@Autowired
	JsonParserService jsonParserService;

	// Load Data from XML file using DOM Parser into Database
	@GetMapping("xml/domparser/loadData")
	public BaseResponse loadPersonsByDomParser() {
		BaseResponse baseResponse = new BaseResponse();
		baseResponse.setSuccess(xmlParserService.loadPersonsByDomParser());
		baseResponse.setParser("DOM-Parser");
		return baseResponse;
	}

	// Load Data from XML file using SAX Parser into Database
	@GetMapping("xml/saxparser/loadData")
	public BaseResponse loadPersonsBySaxParser() {
		BaseResponse baseResponse = new BaseResponse();
		baseResponse.setSuccess(xmlParserService.loadPersonsBySaxParser());
		baseResponse.setParser("SAX-Parser");
		return baseResponse;
	}

	// Load Data from XML file using STAX Parser into Database
	@GetMapping("xml/staxparser/loadData")
	public BaseResponse loadPersonsByStaxParser() {
		BaseResponse baseResponse = new BaseResponse();
		baseResponse.setSuccess(xmlParserService.loadPersonsByStaxParser());
		baseResponse.setParser("STAX-Parser");
		return baseResponse;
	}

	// Get All XML Inserted Data
	@GetMapping("xml/persons")
	public List<Person> getAllPersons() {
		return xmlParserService.getAllPersons();
	}

	// Load Data from CSV file into Database
	@GetMapping("csv/loadData")
	public BaseResponse loadCustomerByCsvParser() {
		BaseResponse baseResponse = new BaseResponse();
		baseResponse.setSuccess(csvParserService.loadCustomerByCsvParser());
		baseResponse.setParser("CSV-Parser");
		return baseResponse;
	}

	// Get All CSV Inserted Data
	@GetMapping("csv/customers")
	public List<Customer> getAllCustomers() {
		return csvParserService.getAllCustomers();
	}

	// Load Data from JSON file into Database
	@GetMapping("json/loadData")
	public BaseResponse loadBooksByJsonParser() {
		BaseResponse baseResponse = new BaseResponse();
		baseResponse.setSuccess(jsonParserService.loadBooksByJsonParser());
		baseResponse.setParser("JSON-Parser");
		return baseResponse;
	}

	// Get All JSON Inserted Data
	@GetMapping("json/books")
	public List<Book> getAllBooks() {
		return jsonParserService.getAllBooks();
	}
}
