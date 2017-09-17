package com.iii.emp.service;

import java.util.List;

import com.iii.emp.domain.EmpVO;

public interface EmpService {

	/**
	 * Create new employee
	 * 
	 * @param EmpVO
	 * @return int
	 */
	int addEmp(EmpVO empVO);

	/**
	 * Read selected employee
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
	 * @return int
	 */
	int updateEmp(EmpVO empVO);

	/**
	 * Delete selected employee
	 * 
	 * @param EmpVO
	 * @return int
	 */
	int delete(EmpVO empVO);

	/**
	 * Reed employees by like SQL
	 * 
	 * @param Integer
	 * @return EmpVO
	 */
	List<EmpVO> getEmpBySqlLike(EmpVO empVO);

}
