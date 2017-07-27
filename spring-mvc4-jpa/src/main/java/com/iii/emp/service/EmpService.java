package com.iii.emp.service;

import java.util.List;

import com.iii.emp.model.EmpVO;

public interface EmpService {
	EmpVO getEmp(Integer empno);

	List<EmpVO> getEmps();

	EmpVO updateEmp(EmpVO empVO);

	EmpVO addEmp(EmpVO empVO);

	void delete(Integer empno);

	void updateCheckedEmpsDeptno(List<EmpVO> empsParam);

}
