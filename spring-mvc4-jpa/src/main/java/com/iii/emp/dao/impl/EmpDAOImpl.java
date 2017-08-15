package com.iii.emp.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.iii.emp.dao.EmpDAO;
import com.iii.emp.model.EmpVO;

@Repository("empDAO")
@Transactional
public class EmpDAOImpl implements EmpDAO {

	/**
	 * ## JPA Entity LifeCycle
	 * 
	 * 1. new : new出的VO, 尚未與資料庫有任何關係
	 * 
	 * 2. managed : 使用persist(新增), merge(更新), find(查詢), 會讓 Entity從detached 變為此狀態,
	 * 此時Entity任一屬性有更動則會一起更動
	 * 
	 * 3. detached : 使用clear() 可進入此狀態, 已經對應至資料庫, 但為分離狀態, 此時Entity任一屬性不會影響
	 * 
	 * 4. removed : 使用remove() 刪除脫離
	 * 
	 */

	@PersistenceContext
	public EntityManager entityManager;

	// propagation預設就為REQUIRED, 有錯就rollback
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	@Override
	public EmpVO insert(EmpVO empVO) {
		entityManager.persist(empVO);
		return empVO;

	}

	@Transactional(readOnly = true)
	@Override
	public EmpVO getEmp(Integer empno) {
		return entityManager.find(EmpVO.class, empno);
	}
	
	@Transactional(readOnly = true)
	@Override
	public List<EmpVO> getEmpBySqlLike(String ename) {
		final String sql = "select * from emp2 where ename like '%" + ename + "%'";
		// 第二個參數如果沒有加，回傳的集合會無法將EmpVO正確轉換成JSONObject
		// 猜測應該是程式只能辨別回傳物件只是一包List，但List裡面有什麼不知道
		// 故在解析List成物件的時候只能轉換成JSONArray
		Query query = entityManager.createNativeQuery(sql, EmpVO.class);
		return query.getResultList();
	}
	
	@Transactional(readOnly = false)
	@Override
	public EmpVO update(EmpVO empVO) {
		entityManager.merge(empVO);
		// this line entity lifeCycle is managed, not yet commit
		return empVO;
	}

	@Transactional(readOnly = false)
	@Override
	public void delete(Integer empno) {
		// if you want delete this employee, entity lifeCycle must be managed
		EmpVO empVO = entityManager.find(EmpVO.class, empno);
		entityManager.remove(empVO);
	}

	@Transactional(readOnly = true)
	@Override
	public List<EmpVO> getEmps() {
		// SELECT + Table name FROM Class name + Table name;
		return entityManager.createQuery("select emp2 from EmpVO emp2").getResultList();
	}

	@Transactional
	@Override
	public void updateCheckedEmpsDeptno(List<EmpVO> emps) {
		for (EmpVO emp : emps) {
			entityManager.merge(emp);
		}
	}

	// 查詢
	// @Transactional(readOnly = true)
	// @Override
	// public EmpVO getEmp(Integer empno) {
	// // SELECT + Table name FROM Class name + Table name + WHERE Table name.field;
	// String sql = "select emp2 from EmpVO emp2 where emp2.empno=" + empno;
	// return (EmpVO) entityManager.createQuery(sql).getSingleResult();
	//
	// }
}
