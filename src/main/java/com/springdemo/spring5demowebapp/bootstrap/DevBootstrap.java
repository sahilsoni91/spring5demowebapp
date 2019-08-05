package com.springdemo.spring5demowebapp.bootstrap;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.springdemo.spring5demowebapp.model.Author;
import com.springdemo.spring5demowebapp.model.Book;
import com.springdemo.spring5demowebapp.repositories.AuthorRepository;
import com.springdemo.spring5demowebapp.repositories.BookRepository;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

	private AuthorRepository authorRepository;
	private BookRepository bookRepository;
	
	public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository) {
		super();
		this.authorRepository = authorRepository;
		this.bookRepository = bookRepository;
	}

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		initData();
	}
	
	private void initData() {
		Author kathy = new Author("Kathy", "Siera");
		Book scjp = new Book("SCJP", "12345", "TMH");
		kathy.getBooks().add(scjp);
		scjp.getAuthors().add(kathy);
		
		authorRepository.save(kathy);
		bookRepository.save(scjp);
		
		Author navathe = new Author("Navathe", "Kumar");
		Book dbms = new Book("DBMS", "98765", "Pearson");
		navathe.getBooks().add(dbms);
		
		authorRepository.save(navathe);
		bookRepository.save(dbms);
	}
}
