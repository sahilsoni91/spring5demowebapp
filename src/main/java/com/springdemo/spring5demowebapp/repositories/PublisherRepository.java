package com.springdemo.spring5demowebapp.repositories;

import org.springframework.data.repository.CrudRepository;

import com.springdemo.spring5demowebapp.model.Publisher;

public interface PublisherRepository extends CrudRepository<Publisher, Long>{

}
