package com.iii.emp.dao;

import java.util.*;

import com.iii.emp.model.EmpVO;

public interface EmpDAO {

	// add
	EmpVO insert(EmpVO empVO);

	// update
	EmpVO update(EmpVO empVO);

	// delete
	void delete(Integer empno);

	// get one
	EmpVO getEmp(Integer empno);

	// get all
	List<EmpVO> getEmps();

	// ....
	void updateCheckedEmpsDeptno(List<EmpVO> empParams);

}
