package com.iii.emp.dao;

import java.util.*;

import com.iii.emp.vo.EmpVO;

public interface EmpDAO {
	// get one
	EmpVO getEmp(Integer empno);

	// get all
	List<EmpVO> getEmps();

	// update
	EmpVO update(EmpVO empVO);

	// add
	EmpVO insert(EmpVO empVO);

	// delete
	void delete(Integer empno);

	// ....
	void updateCheckedEmpsDeptno(List<EmpVO> empParams);

}
