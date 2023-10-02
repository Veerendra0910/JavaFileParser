package com.springboot.springbootparser.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.springboot.springbootparser.dao.CsvParserDao;
import com.springboot.springbootparser.entity.Customer;
import com.springboot.springbootparser.parser.CsvParserExample;

@Service
public class CsvParserService {

	@Autowired
	CsvParserDao csvParserDao;
	
	@Autowired
	CsvParserExample csvParserExample;
	
	@Value("${csv.file.path}")
	private String csvFilePath;
	
	public Boolean loadCustomerByCsvParser() {
		return csvParserDao.loadCustomers(csvParserExample.parseCsvFile(csvFilePath));
	}
	
	public List<Customer> getAllCustomers(){
		return csvParserDao.getAllCustomers();
	}
}
