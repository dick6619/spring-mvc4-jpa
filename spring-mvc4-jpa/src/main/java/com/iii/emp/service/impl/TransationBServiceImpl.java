
package com.iii.emp.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.iii.emp.dao.TransationBDAO;
import com.iii.emp.domain.Book;
import com.iii.emp.service.TransationBService;

@Service
public class TransationBServiceImpl implements TransationBService {

	@Resource
	TransationBDAO transationBDAO;

	@Override
	public List<Book> getAllB() {
		return transationBDAO.readAllB();
	}

	// 測試交易管理， inner method
	@Override
	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public void deleteB(Book book) {
		transationBDAO.deleteB(book);
		throw new RuntimeException("inner method throw RuntimeException after bDAO delete book");
	}

}
