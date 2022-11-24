package com.roxana.presentation;

import java.util.Collection;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.roxana.book.Book;
import com.roxana.service.BookService;

@Component("presentation")
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
			System.out.println("4. Delete Book");
			System.out.println("5. Update number of pages");
			System.out.println("6. Exit");
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
				scanner.nextLine();
				System.out.println("Enter Book Name : ");
				newBook.setBookName(scanner.nextLine());
				System.out.println("Enter Author Name : ");
				newBook.setAuthorName(scanner.nextLine());
				System.out.println("Enter number of pages : ");
				newBook.setNoOfPages(scanner.nextInt());
				scanner.nextLine();
				
				if(bookService.addBook(newBook))
					System.out.println("Book Record Added");
				else
					System.out.println("Book with id "+newBook.getBookId()+" already exists, so cannot add it as a new employee!");
				
				break;
				
			case 4:
				System.out.println("Enter Book ID : ");
				int bookId=scanner.nextInt();
				if(bookService.deleteBook(bookId))
					System.out.println("Employee with id "+bookId+" deleted");
				else
					System.out.println("Employee with id "+bookId+" does not exist");
				break;
				
			case 5:
				System.out.println("Enter Book ID : ");
				int book_Id=scanner.nextInt();
				System.out.println("Enter new No of Pages : ");
				int pages=scanner.nextInt();
				if(bookService.newPages(book_Id, pages))
					System.out.println("Book with Id "+book_Id+" new page number is "+pages);
				else
					System.out.println("Book with ID "+book_Id+" does not exist");
				break;
				
			case 6:
				System.out.println("Thank your for using Book Management System. Goodbye!");
				System.exit(0);
				break;
				
			default:
				System.out.println("No such option is available");
			}
			
		}

	}

