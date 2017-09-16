package com.iii.emp.dao;

import java.util.*;

import com.iii.emp.domain.EmpVO;

public interface EmpDAO {

	/**
	 * Create new employee
	 * 
	 * @param EmpVO
	 * @return EmpVO
	 */
	void insert(EmpVO empVO);

	/**
	 * Reed selected employee
	 * 
	 * @param Integer
	 * @return EmpVO
	 */
	EmpVO getEmp(EmpVO empVO);

	/**
	 * Read all employee
	 * 
	 * @return List<EmpVO>
	 */
	List<EmpVO> getEmps();

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
	void delete(EmpVO empVO);

	/**
	 * Reed employees by like SQL
	 * 
	 * @param Integer
	 * @return EmpVO
	 */
	List<EmpVO> getEmpBySqlLike(EmpVO empVO);

}
