package com.iii.emp.ws.rest;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.iii.emp.domain.Book;
import com.iii.emp.service.TransationAService;
import com.iii.emp.service.TransationBService;

@RestController
@RequestMapping("/test")
public class TestTransationWS {

	@Resource
	TransationAService aService;
	@Resource
	TransationBService bService;

	@GetMapping("/allBook")
	public List<Book> getAllBook() {
		return aService.getAllA();
	}

	@GetMapping("/deleteBook/{bookNo}")
	public void deleteBook(@PathVariable("bookNo") String bookNo) {
		Book book = new Book();
		book.setBookNo(Integer.valueOf(bookNo));
		aService.deleteA(book);
	}

	@GetMapping("/testTransation")
	public void testTransation() {

	}

}
