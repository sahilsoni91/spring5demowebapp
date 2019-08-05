package com.springdemo.spring5demowebapp.repositories;

import org.springframework.data.repository.CrudRepository;

import com.springdemo.spring5demowebapp.model.Book;

public interface BookRepository extends CrudRepository<Book, Long>{

}
