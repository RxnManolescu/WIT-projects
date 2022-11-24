package com.roxana.client;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.roxana")
public class ClientConfiguration {

//	@Bean(name="dao")
//	public BookDaoImpl getPersistence() {
//		return new BookDaoImpl();
//	}
//	
//	@Bean(name="service")
//	public BookServiceImpl getBookService() {
//		//Constructor Injection
//		return new BookServiceImpl(getPersistence());
//	}
//	
//	@Bean(name="bookPresentation")
//	public BookPresentationImpl getBookPresentation() {
//		//Setter Injection
//		BookPresentationImpl presentation=new BookPresentationImpl();
//		presentation.setBookService(getBookService());
//		return presentation;
//	}
}

