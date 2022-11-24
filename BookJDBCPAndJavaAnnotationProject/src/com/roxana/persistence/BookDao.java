package com.roxana.persistence;

import java.util.Collection;

import com.roxana.book.Book;

public interface BookDao {

	 Collection<Book> getAllRecords();

	    Book searchRecord(int id);

	    int insertRecord(Book book);
	    
	    int deleteRecord(int id);
	    
	    int updatePages(int id, int numberOfPages);
}
