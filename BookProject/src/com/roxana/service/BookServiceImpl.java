package com.roxana.service;

import java.util.Collection;

import com.roxana.book.Book;
import com.roxana.persistence.BookDao;

public class BookServiceImpl implements BookService {

	private BookDao bookDao;

	public BookServiceImpl(BookDao bookDao) {
		super();
		this.bookDao = bookDao;
	}

	@Override
	public Collection<Book> getAllBooks() {
		return bookDao.getAllRecords();
	}

	@Override
	public Book searchBookById(int id) {
		return bookDao.searchRecord(id);
	}

	@Override
	public boolean addBook(Book b) {
		Book book = bookDao.searchRecord(b.getBookId());
		if(book!=null) {
			return false;
		}
		bookDao.insertRecord(b);
		return true;
	}

	@Override
	public boolean newPages(int id, int newPageNumber) {
		Book book = bookDao.searchRecord(id);
		if(book==null) {
			return false;
		}
		book.setNoOfPages(newPageNumber);
		bookDao.insertRecord(book);
		return true;
	}
}
