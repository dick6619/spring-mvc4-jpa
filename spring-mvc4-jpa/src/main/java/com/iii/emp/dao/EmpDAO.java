package com.iii.emp.dao;

import java.util.*;

import com.iii.emp.model.EmpVO;

public interface EmpDAO {

	/**
	 * add employee
	 * @param EmpVO
	 * @return EmpVO
	 */
	EmpVO insert(EmpVO empVO);

	/**
	 * update employee
	 * @param EmpVO
	 * @return EmpVO
	 */
	EmpVO update(EmpVO empVO);

	/**
	 * delete employee
	 * @param EmpVO
	 */
	void delete(Integer empno);

	/**
	 * query employee
	 * @param Integer
	 * @return EmpVO
	 */
	EmpVO getEmp(Integer empno);

	/**
	 * query all employees
	 * @return List<EmpVO>
	 */
	List<EmpVO> getEmps();

	/**
	 *
	 * */
	void updateCheckedEmpsDeptno(List<EmpVO> empParams);

}
