package com.roxana.service;

import java.util.Collection;

import org.springframework.stereotype.Service;

import com.roxana.book.Book;
import com.roxana.persistence.BookDao;

@Service("service")
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
		if(bookDao.updatePages(id, newPageNumber)>0) {
			return true;
		}
		return false;
	}

	@Override
	public boolean deleteBook(int id) {
		if(bookDao.deleteRecord(id)>0)
			return true;
		return false;
	}
}
