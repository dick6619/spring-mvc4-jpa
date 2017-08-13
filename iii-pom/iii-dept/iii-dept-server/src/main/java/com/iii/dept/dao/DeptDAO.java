package com.iii.dept.dao;

import java.util.*;

import com.iii.dept.entity.DeptVO;
import com.iii.emp.entity.EmpVO;

public interface DeptDAO {
	DeptVO insert(DeptVO deptVO);

	DeptVO getDept(Integer deptno);

	DeptVO update(DeptVO deptVO);

	void delete(Integer deptno);

	List<DeptVO> getDepts();

	Set<EmpVO> getEmpsByDeptno(Integer deptno);
}
