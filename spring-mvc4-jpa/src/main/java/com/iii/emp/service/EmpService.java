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
	void addEmp(EmpVO empVO);

	/**
	 * Read selected employee
	 * 
	 * @param Integer
	 * @return EmpVO
	 */
	EmpVO getEmp(Integer empno);

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
	EmpVO updateEmp(EmpVO empVO);

	/**
	 * Delete selected employee
	 * 
	 * @param empno
	 */
	void delete(Integer empno);

	/**
	 * Reed employees by like SQL
	 * 
	 * @param Integer
	 * @return EmpVO
	 */
	List<EmpVO> getEmpBySqlLike(String ename);

}
