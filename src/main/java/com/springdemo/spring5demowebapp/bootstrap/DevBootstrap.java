package com.springdemo.spring5demowebapp.bootstrap;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.springdemo.spring5demowebapp.model.Author;
import com.springdemo.spring5demowebapp.model.Book;
import com.springdemo.spring5demowebapp.model.Publisher;
import com.springdemo.spring5demowebapp.repositories.AuthorRepository;
import com.springdemo.spring5demowebapp.repositories.BookRepository;
import com.springdemo.spring5demowebapp.repositories.PublisherRepository;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

	private AuthorRepository authorRepository;
	private BookRepository bookRepository;
	private PublisherRepository publisherRepository;
	
	public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository,
			PublisherRepository publisherRepository) {
		super();
		this.authorRepository = authorRepository;
		this.bookRepository = bookRepository;
		this.publisherRepository = publisherRepository;
	}

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		initData();
	}
	
	private void initData() {
		Publisher tmh = new Publisher();
		tmh.setName("TMH");
		tmh.setAddress("USA");
		publisherRepository.save(tmh);
		
		Publisher pearson = new Publisher();
		pearson.setName("Pearson");
		pearson.setAddress("UK");
		publisherRepository.save(pearson);
		
		Author kathy = new Author("Kathy", "Siera");
		Book scjp = new Book("SCJP", "12345", tmh);
		kathy.getBooks().add(scjp);
		scjp.getAuthors().add(kathy);
		
		authorRepository.save(kathy);
		bookRepository.save(scjp);
		
		Author navathe = new Author("Navathe", "Kumar");
		Book dbms = new Book("DBMS", "98765", pearson);
		navathe.getBooks().add(dbms);
		
		authorRepository.save(navathe);
		bookRepository.save(dbms);
	}
}
