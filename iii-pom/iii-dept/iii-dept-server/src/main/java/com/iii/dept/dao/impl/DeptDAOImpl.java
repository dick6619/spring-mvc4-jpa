package com.iii.dept.dao.impl;

import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.iii.dept.dao.DeptDAO;
import com.iii.dept.entity.DeptVO;
import com.iii.emp.entity.EmpVO;

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
	public List<DeptVO> getDepts() {
		String sql = "select dept2 from DeptVO dept2";
		return entityManager.createQuery(sql).getResultList();
	}

	@Override
	public Set<EmpVO> getEmpsByDeptno(Integer deptno) {
		return null;
	}

}
