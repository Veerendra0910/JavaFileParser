package com.springboot.springbootparser.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.springbootparser.entity.Person;

public interface PersonRepository extends JpaRepository<Person, Integer> {

}
