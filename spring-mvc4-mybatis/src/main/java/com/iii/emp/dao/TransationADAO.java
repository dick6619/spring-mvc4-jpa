package com.iii.emp.dao;

import java.util.List;

import com.iii.emp.domain.Book;

public interface TransationADAO {
	List<Book> readAllA();

	void deleteA(Book book);

	void updateA(Book book);
}
