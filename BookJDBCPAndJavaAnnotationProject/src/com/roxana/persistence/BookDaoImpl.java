package com.roxana.persistence;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.roxana.book.Book;

@Repository("Dao")
public class BookDaoImpl implements BookDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public Collection<Book> getAllRecords() {
		
		String query = "SELECT * FROM BOOKS";
		List<Book> empList = jdbcTemplate.query(query, new BookRowMapper());
		return empList;
	}

	@Override
	public Book searchRecord(int id) {
		
		Book book = null;
		try {
			String query = "SELECT * FROM BOOKS WHERE BOOK_ID=?";
			book = jdbcTemplate.queryForObject(query, new BookRowMapper(), id);
		} catch (EmptyResultDataAccessException ex) {
			return null;
		}
		return book;
	}

	
	
	@Override
	public int insertRecord(Book book) {
		try {
		
			String query = "INSERT INTO BOOKS VALUES(?,?,?,?)";
			
			int rows = jdbcTemplate.update(query, book.getBookId(), book.getBookName(), book.getAuthorName(), book.getNoOfPages());
			
			return rows;
		} catch (DuplicateKeyException ex) {
			return 0;
		}
	}
	
	public int updatePages(int id, int newPages) {
		String query = "UPDATE BOOKS SET NO_OF_PAGES = ? WHERE BOOK_ID=?";
		int rows = jdbcTemplate.update(query, newPages, id);
		return rows;
	}
	
	@Override
	public int deleteRecord(int id) {

		String query = "DELETE FROM BOOKS WHERE BOOK_ID=?";
		int rows = jdbcTemplate.update(query, id);

		return rows;
	}
	

}
