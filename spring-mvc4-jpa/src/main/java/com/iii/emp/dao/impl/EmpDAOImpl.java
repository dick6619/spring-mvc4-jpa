package com.iii.emp.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.iii.emp.dao.EmpDAO;
import com.iii.emp.vo.EmpVO;

@Repository("empDAO")
@Transactional
public class EmpDAOImpl implements EmpDAO {

	/**
	 * jpa 中的 entity 有生命週期 1. new : new出的VO, 尚未與資料庫有任何關係 2. managed : 使用
	 * persist(新增), merge(更新), find(查詢), 會讓 Entity從detached 變為此狀態,
	 * 此時Entity任一屬性有更動則會一起更動 3. detached : 使用clear() 可進入此狀態, 已經對應至資料庫, 但為分離狀態,
	 * 此時Entity任一屬性不會影響 4. removed : 使用remove() 刪除脫離
	 * 
	 * 
	 */
	@PersistenceContext
	public EntityManager entityManager;

	// 查詢
	// @Transactional(readOnly = true)
	// @Override
	// public EmpVO getEmp(Integer empno) {
	// // SELECT + Table name FROM Class name + Table name + WHERE Table
	// // name.field;
	// String sql = "select emp2 from EmpVO emp2 where emp2.empno=" + empno;
	// return (EmpVO) entityManager.createQuery(sql).getSingleResult();
	//
	// }
	// 查詢
	@Transactional(readOnly = true)
	@Override
	public EmpVO getEmp(Integer empno) {
		// 不確定要不要關
		// EmpVO empVO = entityManager.find(EmpVO.class, empno);
		// entityManager.clear();
		return entityManager.find(EmpVO.class, empno);

	}

	@Transactional(readOnly = true)
	@Override
	public List<EmpVO> getEmps() {
		// SELECT + Table name FROM Class name + Table name;
		String sql = "select emp2 from EmpVO emp2";
		return entityManager.createQuery(sql).getResultList();
	}

	@Transactional(readOnly = false)
	@Override
	public EmpVO update(EmpVO empVO) {
		entityManager.merge(empVO);
		// 尚未commit，就關掉entity週期，導致沒更新
		// entityManager.clear();
		// 估計是return這行commit
		return empVO;
	}

	@Transactional(readOnly = false)
	@Override
	public EmpVO insert(EmpVO empVO) {
		entityManager.persist(empVO);
		// 不會影響到新增，上一行已經commit
		// entityManager.clear();
		return empVO;

	}

	@Transactional(readOnly = false)
	@Override
	public void delete(Integer empno) {
		// 得先讓生命週期變為managed，才能刪除
		EmpVO empVO = entityManager.find(EmpVO.class, empno);
		entityManager.remove(empVO);
	}

	// ...
	@Override
	public void updateCheckedEmpsDeptno(List<EmpVO> empsParams) {
		// TODO Auto-generated method stub
		// 無法辨識集合內的java entity
		// entityManager.merge(empsParams);
		for (EmpVO emp : empsParams) {
			entityManager.merge(emp);
		}
	}

}
