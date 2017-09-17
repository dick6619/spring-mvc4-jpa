package com.iii.emp.dao.impl;

import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.iii.emp.dao.DeptDAO;
import com.iii.emp.domain.DeptVO;
import com.iii.emp.domain.EmpVO;

@Repository
@Transactional
public class DeptDAOImpl implements DeptDAO {

	@PersistenceContext
	public EntityManager entityManager;

	@Override
	public DeptVO insert(DeptVO deptVO) {
		entityManager.persist(deptVO);
		return deptVO;
	}

	@Override
	public DeptVO getDept(Integer deptno) {
		return entityManager.find(DeptVO.class, deptno);
	}

	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	@Override
	public List<DeptVO> getDepts() {
		final String sql = "select * from dept2";
		return entityManager.createNativeQuery(sql, DeptVO.class).getResultList();
	}

	@Override
	public DeptVO update(DeptVO deptVO) {
		return entityManager.merge(deptVO);
	}

	@Override
	public void delete(Integer deptno) {
		DeptVO deptVO = entityManager.find(DeptVO.class, deptno);
		entityManager.remove(deptVO);
	}

	@Override
	public Set<EmpVO> getEmpsByDeptno(Integer deptno) {
		return null;
	}

}
