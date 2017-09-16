package com.iii.emp.service;

import java.util.List;

import com.iii.emp.domain.Book;

public interface TransationBService {
	void deleteB(Book book);
	
	List<Book> getAllB();
}
