package com.iii.emp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.iii.emp.dao.EmpDAO;
import com.iii.emp.model.EmpVO;
import com.iii.emp.service.EmpService;

@Service("empService")
@Transactional
public class EmpServiceImpl implements EmpService {

	@Autowired(required = true)
	@Qualifier("empDAO")
	private EmpDAO empDAO;

	@Override
	public EmpVO addEmp(EmpVO empVO) {
		return empDAO.insert(empVO);
	}
	
	@Override
	public EmpVO getEmp(Integer empno) {
		return empDAO.getEmp(empno);
	}

	@Override
	public EmpVO updateEmp(EmpVO empVO) {
		return empDAO.update(empVO);
	}

	@Override
	public void delete(Integer empno) {
		empDAO.delete(empno);
	}

	@Override
	public List<EmpVO> getEmps() {
		return empDAO.getEmps();
	}

	@Override
	public void updateCheckedEmpsDeptno(List<EmpVO> empsParams) {
		empDAO.updateCheckedEmpsDeptno(empsParams);
	}

}
