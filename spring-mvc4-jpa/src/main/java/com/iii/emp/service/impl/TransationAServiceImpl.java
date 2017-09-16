
package com.iii.emp.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.iii.emp.dao.TransationADAO;
import com.iii.emp.domain.Book;
import com.iii.emp.service.TransationAService;
import com.iii.emp.service.TransationBService;

@Service
public class TransationAServiceImpl implements TransationAService {

	@Resource
	TransationADAO transationADAO;
	
	// 測試交易管理 aop proxy
	@Resource
	TransationBService bService;

	@Override
	public List<Book> getAllA() {
		return transationADAO.readAllA();
	}

	// 測試交易管理, outer method
	@Override
	@Transactional
	public void deleteA(Book book) {
		// outer method delete book ?
		transationADAO.deleteA(book);
		// inner method delete book 17
		book.setBookNo(17);
		bService.deleteB(book);
//		throw new RuntimeException("outer method throw RuntimeException after bService delete book");
	}

}
