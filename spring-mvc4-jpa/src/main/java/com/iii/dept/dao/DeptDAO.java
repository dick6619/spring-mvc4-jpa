package com.iii.dept.dao;

import java.util.*;

import com.iii.dept.model.DeptVO;
import com.iii.emp.model.EmpVO;

public interface DeptDAO {
	// add
	DeptVO insert(DeptVO deptVO);

	// update
	DeptVO update(DeptVO deptVO);

	// delete
	void delete(Integer deptno);

	// get one
	DeptVO getDept(Integer deptno);

	// get all
	List<DeptVO> getDepts();

	// 查詢某部門的員工(一對多)(回傳 Set)
	Set<EmpVO> getEmpsByDeptno(Integer deptno);
}
