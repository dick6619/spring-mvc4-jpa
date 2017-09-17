package com.iii.emp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.iii.emp.dao.EmpDAO;
import com.iii.emp.domain.EmpVO;
import com.iii.emp.service.EmpService;

@Service("empService")
@Transactional
public class EmpServiceImpl implements EmpService {

	@Autowired
	private EmpDAO empDAO;

	@Override
	public int addEmp(EmpVO empVO) {
		return empDAO.insert(empVO);
	}

	@Override
	public EmpVO getEmp(EmpVO empvo) {
		return empDAO.getEmp(empvo);
	}

	@Override
	public List<EmpVO> getEmps() {
		return empDAO.getEmps();
	}

	@Override
	public int updateEmp(EmpVO empVO) {
		return empDAO.update(empVO);
	}

	@Override
	public int delete(EmpVO empVO) {
		return empDAO.delete(empVO);
	}

	@Override
	public List<EmpVO> getEmpBySqlLike(EmpVO empVO) {
		return empDAO.getEmpBySqlLike(empVO);
	}

}
