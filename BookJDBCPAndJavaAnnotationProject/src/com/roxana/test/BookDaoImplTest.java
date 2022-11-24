package com.roxana.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.roxana.book.Book;
import com.roxana.persistence.BookDaoImpl;

class BookDaoImplTest {
	
	BookDaoImpl bookDaoImpl;

	@BeforeEach
	void setUp() throws Exception {
		bookDaoImpl = new BookDaoImpl();
	}

	@AfterEach
	void tearDown() throws Exception {
		bookDaoImpl = null;
	}

	@Test
	void testGetAllRecords() {
		assertTrue(bookDaoImpl.getAllRecords().size()>0);
	}

	@Test
	void testSearchRecord() {
		assertTrue(bookDaoImpl.searchRecord(101)!=null);
	}

	@Test
	void testInsertRecord() {
		assertEquals(1, bookDaoImpl.insertRecord(new Book(106, "lia", "Sophia", 700)));
	}

}
