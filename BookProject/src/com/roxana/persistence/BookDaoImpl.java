package com.roxana.persistence;

import java.util.Collection;

import com.roxana.book.Book;
import com.roxana.database.BookDatabase;

public class BookDaoImpl implements BookDao{

    @Override
    public Collection<Book> getAllRecords() {
        return BookDatabase.getBookList().values();
    }

    @Override
    public Book searchRecord(int id) {
        return BookDatabase.getBookList().get(id);

    }

    @Override
    public Book insertRecord(Book book) {
        return BookDatabase.getBookList().put(book.getBookId(), book);
    }



}
