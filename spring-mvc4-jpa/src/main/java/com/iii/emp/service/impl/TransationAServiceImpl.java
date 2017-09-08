
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
	
	// 測試交易管理
	@Resource
	TransationBService bService;

	@Override
	public List<Book> getAllA() {
		return transationADAO.readAllA();
	}

	// 測試交易管理
	@Override
	@Transactional(noRollbackFor = RuntimeException.class)
	public void deleteA(Book book) {
		transationADAO.deleteA(book);
		
		// 呼叫b service
		book.setBookNo(17);
		bService.deleteB(book);

	}

	@Override
	public void updateA(Book book) {
		transationADAO.updateA(book);

	}

}
