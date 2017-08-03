package com.iii.emp.service;

import java.util.List;

import com.iii.emp.model.EmpVO;

public interface EmpService {

	EmpVO addEmp(EmpVO empVO);

	EmpVO updateEmp(EmpVO empVO);

	void delete(Integer empno);

	EmpVO getEmp(Integer empno);

	List<EmpVO> getEmps();

	void updateCheckedEmpsDeptno(List<EmpVO> empsParam);

}
