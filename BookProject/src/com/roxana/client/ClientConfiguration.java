package com.roxana.client;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.roxana.persistence.BookDaoImpl;
import com.roxana.presentation.BookPresentationImpl;
import com.roxana.service.BookServiceImpl;

@Configuration
public class ClientConfiguration {

	@Bean(name="dao")
	public BookDaoImpl getPersistence() {
		return new BookDaoImpl();
	}
	
	@Bean(name="service")
	public BookServiceImpl getBookService() {
		//Constructor Injection
		return new BookServiceImpl(getPersistence());
	}
	
	@Bean(name="bookPresentation")
	public BookPresentationImpl getBookPresentation() {
		//Setter Injection
		BookPresentationImpl presentation=new BookPresentationImpl();
		presentation.setBookService(getBookService());
		return presentation;
	}
}

