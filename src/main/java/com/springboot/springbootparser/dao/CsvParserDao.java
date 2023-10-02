package com.springboot.springbootparser.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.springboot.springbootparser.entity.Customer;
import com.springboot.springbootparser.repository.CustomerRepository;

@Component
public class CsvParserDao {

	@Autowired
	CustomerRepository customerRepository;

	public Boolean loadCustomers(List<Customer> listOfCustomers) {
		Boolean success = Boolean.FALSE;
		if (!listOfCustomers.isEmpty()) {
			for (Customer customer : listOfCustomers) {
				customerRepository.save(customer);
				success = Boolean.TRUE;
			}
		}
		return success;
	}

	public List<Customer> getAllCustomers() {
		return customerRepository.findAll();
	}
}
