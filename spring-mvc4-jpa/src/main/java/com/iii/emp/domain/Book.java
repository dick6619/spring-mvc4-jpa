package com.iii.emp.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "book")
public class Book {
	
	public Book(){
	}
	
	@Id
	@Column(name = "book_no") // 屬性成員與table欄位名稱一樣時則不需要@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer bookNo;
	
	@Column(name = "book_name")
	String bookName;
	
	public Integer getBookNo() {
		return bookNo;
	}
	public void setBookNo(Integer bookNo) {
		this.bookNo = bookNo;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	
	

}
