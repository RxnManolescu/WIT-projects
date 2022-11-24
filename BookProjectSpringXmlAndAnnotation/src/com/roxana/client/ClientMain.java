package com.roxana.client;

import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.roxana.presentation.BookPresentation;

public class ClientMain {

	public static void main(String[] args) {
Scanner scanner=new Scanner(System.in);
		
//		AnnotationConfigApplicationContext springContainer=new AnnotationConfigApplicationContext(ClientConfiguration.class);
		
		ApplicationContext springContainer = new ClassPathXmlApplicationContext("BookXml.xml");

		BookPresentation bookPresentation=(BookPresentation)springContainer.getBean("bookPresentation");
		while(true) {
			bookPresentation.showMenu();
			System.out.println("Enter Choice : ");
			int choice=scanner.nextInt();
			bookPresentation.performMenu(choice);
			
		}
	}

}
