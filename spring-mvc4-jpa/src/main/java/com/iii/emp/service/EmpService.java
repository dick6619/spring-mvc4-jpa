package com.iii.emp.service;

import java.util.List;

import com.iii.emp.domain.EmpVO;

public interface EmpService {

	/**
	 * Create new employee
	 * 
	 * @param EmpVO
	 * @return EmpVO
	 */
	void addEmp(EmpVO eParam);

	/**
	 * Read selected employee
	 * 
	 * @param Integer
	 * @return EmpVO
	 */
	EmpVO getEmp(EmpVO eParam);

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
	EmpVO updateEmp(EmpVO eParam);

	/**
	 * Delete selected employee
	 * 
	 * @param empno
	 */
	void delete(EmpVO eParam);

	/**
	 * Reed employees by like SQL
	 * 
	 * @param Integer
	 * @return EmpVO
	 */
	List<EmpVO> getEmpBySqlLike(EmpVO eParam);

}
