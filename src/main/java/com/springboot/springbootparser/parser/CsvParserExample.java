package com.springboot.springbootparser.parser;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Component;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.springboot.springbootparser.entity.Customer;

@Component
public class CsvParserExample {

	public List<Customer> parseCsvFile(String csvFilePath) {
		List<Customer> customers = new ArrayList<>();

		try {
			CSVReader csvReader = new CSVReaderBuilder(new FileReader(new File(csvFilePath))).withSkipLines(1).build();

			List<String[]> records = csvReader.readAll();

			Iterator<String[]> iterator = records.iterator();

			while (iterator.hasNext()) {
				String[] customerRecord = iterator.next();
				Customer customer = new Customer();
				customer.setId(Integer.parseInt(customerRecord[0]));
				customer.setFirstName(customerRecord[1]);
				customer.setLastName(customerRecord[2]);
				customer.setEmail(customerRecord[3]);
				customer.setGender(customerRecord[4]);
				customer.setContactNo(customerRecord[5]);
				customer.setCountry(customerRecord[6]);
				customer.setDob(customerRecord[7]);
				customers.add(customer);
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
		return customers;
	}
}
