package com.iii.emp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.iii.emp.dao.EmpDAO;
import com.iii.emp.domain.EmpVO;
import com.iii.emp.service.EmpService;

@Service
@Transactional
public class EmpServiceImpl implements EmpService {

	@Autowired(required = true)
	@Qualifier
	private EmpDAO empDAO;

	@Override
	public void addEmp(EmpVO empVO) {
		empDAO.insert(empVO);
	}

	@Override
	public EmpVO getEmp(EmpVO empVO) {
		return empDAO.getEmp(empVO);
	}

	@Override
	public List<EmpVO> getEmps() {
		return empDAO.getEmps();
	}

	@Override
	public EmpVO updateEmp(EmpVO empVO) {
		return empDAO.update(empVO);
	}

	@Override
	public void delete(EmpVO empVO) {
		empDAO.delete(empVO);
	}

	@Override
	public List<EmpVO> getEmpBySqlLike(EmpVO empVO) {
		return empDAO.getEmpBySqlLike(empVO);
	}

}
