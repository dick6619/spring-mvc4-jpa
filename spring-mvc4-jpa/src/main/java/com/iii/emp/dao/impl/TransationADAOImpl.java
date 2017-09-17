package com.iii.emp.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.iii.emp.dao.TransationADAO;
import com.iii.emp.domain.Book;

@Repository
public class TransationADAOImpl implements TransationADAO {

	@PersistenceContext
	public EntityManager entityManager;

	@SuppressWarnings("unchecked")
	@Override
	public List<Book> readAllA() {
		final String sql = "select * from book";
		return entityManager.createNativeQuery(sql, Book.class).getResultList();
	}

	@Override
	public void deleteA(Book book) {
		Book b = entityManager.find(Book.class, book.getBookNo());
		entityManager.remove(b);
	}

	@Override
	public void updateA(Book book) {
		entityManager.merge(book);
	}

}
