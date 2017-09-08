
package com.iii.emp.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
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

	// 測試交易管理，noRollbackFor
	@Override
	@Transactional
	public void deleteB(Book book) {
		transationBDAO.deleteB(book);
		throw new RuntimeException("error*****************");
	}

	@Override
	public void updateB(Book book) {
		transationBDAO.updateB(book);
	}

}
