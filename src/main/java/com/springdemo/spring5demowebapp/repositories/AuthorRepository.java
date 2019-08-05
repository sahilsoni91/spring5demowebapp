package com.springdemo.spring5demowebapp.repositories;

import org.springframework.data.repository.CrudRepository;

import com.springdemo.spring5demowebapp.model.Author;

public interface AuthorRepository extends CrudRepository<Author, Long>{

}
