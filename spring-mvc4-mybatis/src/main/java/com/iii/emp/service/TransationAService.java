package com.iii.emp.service;

import java.util.List;

import com.iii.emp.domain.Book;

public interface TransationAService {
	void deleteA(Book book);
	
	List<Book> getAllA();
}
