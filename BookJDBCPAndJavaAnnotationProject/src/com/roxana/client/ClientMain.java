package com.roxana.client;

import java.util.Scanner;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.roxana.book.BookConfiguration;
import com.roxana.presentation.BookPresentation;

public class ClientMain {

	public static void main(String[] args) {
		
		Scanner scanner=new Scanner(System.in);
		
		AnnotationConfigApplicationContext springContainer = new AnnotationConfigApplicationContext(BookConfiguration.class);
		
		BookPresentation bookPresentation =(BookPresentation)springContainer.getBean("presentation");
		while(true) {
			bookPresentation.showMenu();
			System.out.println("Enter Choice : ");
			int choice=scanner.nextInt();
			bookPresentation.performMenu(choice);
		}
	}

}
