package com.iii.dept.dao.impl;

import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.iii.dept.dao.DeptDAO;
import com.iii.dept.model.DeptVO;
import com.iii.emp.model.EmpVO;

public class DeptDAOImpl implements DeptDAO {

	@PersistenceContext
	public EntityManager entityManager;

	@Override
	public DeptVO insert(DeptVO deptVO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DeptVO update(DeptVO deptVO) {
		// TODO Auto-generated method stub
		return null;

	}

	@Override
	public void delete(Integer deptno) {
		// TODO Auto-generated method stub
		DeptVO deptVO = entityManager.find(DeptVO.class, deptno);
		entityManager.remove(deptVO);
	}

	@Override
	public DeptVO getDept(Integer deptno) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<DeptVO> getDepts() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<EmpVO> getEmpsByDeptno(Integer deptno) {
		// TODO Auto-generated method stub
		return null;
	}

}
