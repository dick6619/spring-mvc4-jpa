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
	int addEmp(EmpVO eParam);

	/**
	 * Read selected employee
	 * 
	 * @param EmpVO
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
	 * @return int
	 */
	int updateEmp(EmpVO eParam);

	/**
	 * Delete selected employee
	 * 
	 * @param EmpVO
	 * @return int
	 */
	int delete(EmpVO eParam);

	/**
	 * Reed employees by like SQL
	 * 
	 * @param EmpVO
	 * @return EmpVO
	 */
	List<EmpVO> getEmpBySqlLike(EmpVO eParam);

}
