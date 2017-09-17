package com.iii.emp.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.iii.emp.dao.EmpDAO;
import com.iii.emp.domain.EmpVO;

@Repository
@Transactional
public class EmpDAOImpl implements EmpDAO {

	/**
	 * ## JPA Entity LifeCycle
	 * 
	 * 1. new : new出的VO, 尚未與資料庫有任何關係
	 * 
	 * 2. managed : 使用persist(新增), merge(更新), find(查詢), 會讓 Entity從detached 變為此狀態
	 * 
	 * 3. detached : 使用clear() 可進入此狀態, 已經對應至資料庫, 但為分離狀態, 此時Entity任一屬性不會影響
	 * 
	 * 4. removed : 使用remove() 刪除脫離
	 * 
	 */

	@PersistenceContext
	public EntityManager entityManager;

	@Transactional
	@Override
	public void insert(EmpVO empVO) {
		entityManager.persist(empVO);
	}

	@Transactional(readOnly = true)
	@Override
	public EmpVO getEmp(EmpVO ePraram) {
		return entityManager.find(EmpVO.class, ePraram.getEmpno());
	}

	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	@Override
	public List<EmpVO> getEmps() {
		// SELECT + Table name FROM Class name + Table name;
		return entityManager.createQuery("select emp2 from EmpVO emp2").getResultList();
	}

	@Transactional
	@Override
	public EmpVO update(EmpVO empVO) {
		/*
		 * entityManager.merge(empVO); 
		 * ... this line entity lifeCycle is managed, not yet commit
		 */
		return entityManager.merge(empVO);
	}

	@Transactional
	@Override
	public void delete(EmpVO ePraram) {
		// if you want delete this employee, entity lifeCycle must be managed
		EmpVO empVO = entityManager.find(EmpVO.class, ePraram.getEmpno());
		entityManager.remove(empVO);
	}

	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	@Override
	public List<EmpVO> getEmpBySqlLike(EmpVO ePraram) {
		final String sql = "select * from emp2 where ename like '%" + ePraram.getEname() + "%'";
		// second param need to add, guess the program can't understand who in List
		Query query = entityManager.createNativeQuery(sql, EmpVO.class);
		return query.getResultList();
	}

}
