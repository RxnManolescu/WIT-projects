package com.roxana.book;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode

public class Book {

	private int bookId;
	private String bookName;
	private String authorName;
	private int noOfPages;
}
