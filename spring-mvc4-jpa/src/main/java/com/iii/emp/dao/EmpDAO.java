package com.iii.emp.dao;

import java.util.*;

import com.iii.emp.model.EmpVO;

public interface EmpDAO {

	/**
	 * Create new employee
	 * 
	 * @param EmpVO
	 * @return EmpVO
	 */
	EmpVO insert(EmpVO empVO);

	/**
	 * Reed selected employee
	 * 
	 * @param Integer
	 * @return EmpVO
	 */
	EmpVO getEmp(Integer empno);
	
	/**
	 * Reed employees by like SQL
	 * 
	 * @param Integer
	 * @return EmpVO
	 */
	List<EmpVO> getEmpBySqlLike(String ename);

	/**
	 * Update selected employee
	 * 
	 * @param EmpVO
	 * @return EmpVO
	 */
	EmpVO update(EmpVO empVO);

	/**
	 * Delete selected employee
	 * 
	 * @param Integer
	 */
	void delete(Integer empno);

	/**
	 * Read all employee
	 * 
	 * @return List<EmpVO>
	 */
	List<EmpVO> getEmps();

	/**
	 *
	 * */
	void updateCheckedEmpsDeptno(List<EmpVO> empParams);

}
