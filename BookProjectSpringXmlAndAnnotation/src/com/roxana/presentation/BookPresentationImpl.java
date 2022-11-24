package com.roxana.presentation;

import java.util.Collection;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.roxana.book.Book;
import com.roxana.service.BookService;

@Component("bookPresentation")
public class BookPresentationImpl implements BookPresentation{
	
	private BookService bookService;
	
	@Autowired
	public void setBookService(BookService bookService) {
		this.bookService = bookService;
	}

		@Override
		public void showMenu() {
			System.out.println("===========================");
			System.out.println("Employee Management System");
			System.out.println("1. List All Book");
			System.out.println("2. Search Book By ID");
			System.out.println("3. Add New Book");
			System.out.println("4. Edit number of pages");
			System.out.println("5. Exit");
			System.out.println("============================");
			
		}

		@Override
		public void performMenu(int choice) {
			Scanner scanner = new Scanner(System.in);
			
			switch (choice) {
			
			case 1: 
				Collection<Book> books= bookService.getAllBooks();
				for(Book book : books) {
					System.out.println(book);
				}
				break;
			case 2: 
				System.out.println("Enter Book ID : ");
				int id=scanner.nextInt();
				Book book= bookService.searchBookById(id);
				if(book != null)
					System.out.println(book);
				else
					System.out.println("Book with id "+id+" does not exist");
				break;

			case 3:
				
				Book newBook=new Book();
				
				System.out.println("Enter Book id : ");
				newBook.setBookId(scanner.nextInt());
				System.out.println("Enter Book Name : ");
				newBook.setBookName(scanner.next());
				System.out.println("Enter Author Name : ");
				newBook.setAuthorName(scanner.next());
				System.out.println("Enter number of pages : ");
				newBook.setNoOfPages(scanner.nextInt());
				
				if(bookService.addBook(newBook))
					System.out.println("Book Record Added");
				else
					System.out.println("Book with id "+newBook.getBookId()+" already exist, so cannot add it as a new employee!");
				
				break;
			case 4:
				System.out.println("Enter Book ID : ");
				int bookId=scanner.nextInt();
				System.out.println("Enter new No of Pages : ");
				int pages=scanner.nextInt();
				if(bookService.newPages(bookId, pages))
					System.out.println("Book with Id "+bookId+" new page number is "+pages);
				else
					System.out.println("Book with ID "+bookId+" does not exist");
				break;

			case 5:
				System.out.println("Thank your for using Book Management System. Goodbye!");
				System.exit(0);
				break;
			default:
				System.out.println("No such option is available");
			}
			
		}

	}

