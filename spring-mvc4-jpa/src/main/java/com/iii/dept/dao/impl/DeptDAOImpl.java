package com.iii.dept.dao.impl;

import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.iii.dept.dao.DeptDAO;
import com.iii.dept.model.DeptVO;
import com.iii.emp.model.EmpVO;

@Repository("deptDAO")
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

	@Override
	public DeptVO update(DeptVO deptVO) {
		return entityManager.merge(deptVO);
	}

	@Override
	public void delete(Integer deptno) {
		DeptVO deptVO = entityManager.find(DeptVO.class, deptno);
		entityManager.remove(deptVO);
	}

	@Transactional(readOnly = true)
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
