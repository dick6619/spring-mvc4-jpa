package com.iii.dept.dao;

import java.util.*;

import com.iii.dept.domain.DeptVO;
import com.iii.emp.domain.EmpVO;

public interface DeptDAO {
	DeptVO insert(DeptVO deptVO);

	DeptVO getDept(Integer deptno);

	List<DeptVO> getDepts();

	DeptVO update(DeptVO deptVO);

	void delete(Integer deptno);

	Set<EmpVO> getEmpsByDeptno(Integer deptno);
}
