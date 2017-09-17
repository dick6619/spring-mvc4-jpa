package com.iii.emp.service;

import java.util.List;

import com.iii.emp.vo.EmpVO;

public interface EmpService {

	EmpVO addEmp(EmpVO empVO);

	EmpVO updateEmp(EmpVO empVO);

	EmpVO getEmp(Integer empno);

	List<EmpVO> getEmps();
	
	void delete(Integer empno);

}
