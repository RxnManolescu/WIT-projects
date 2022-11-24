package com.roxana.service;

import java.util.Collection;

import com.roxana.book.Book;

public interface BookService {

	Collection<Book> getAllBooks();

	Book searchBookById(int id);

	boolean addBook(Book book);
	
	boolean deleteBook(int id);
	
	boolean newPages(int id, int newPageNumber);
	
	
}
