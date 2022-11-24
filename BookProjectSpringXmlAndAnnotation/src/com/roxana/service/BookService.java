package com.roxana.service;

import java.util.Collection;

import com.roxana.book.Book;

public interface BookService {

	Collection<Book> getAllBooks();

	Book searchBookById(int id);

	boolean addBook(Book bookO);
	
	boolean newPages(int id, int newPageNumber);
}
