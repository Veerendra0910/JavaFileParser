package com.springboot.springbootparser.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.springbootparser.entity.Book;

public interface BookRepository extends JpaRepository<Book, Integer> {

}
