package com.iii.emp.dao;

import java.util.List;

import com.iii.emp.domain.Book;

public interface TransationBDAO {
	List<Book> readAllB();

	void deleteB(Book book);

	void updateB(Book book);
}
