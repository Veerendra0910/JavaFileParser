package com.springboot.springbootparser.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.springbootparser.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

}
