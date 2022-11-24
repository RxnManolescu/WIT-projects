package com.roxana.test;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.roxana.persistence.BookDaoImpl;

/**
 * 
 */

/**
 * @author LOVE
 *
 */
class BookTest {

	BookDaoImpl bookDaoImpl;
	
	@BeforeEach
	void setUp() throws Exception {
		bookDaoImpl = new BookDaoImpl();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void test() {
		fail("Not yet implemented");
	}

}
