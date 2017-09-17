package com.iii.emp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.iii.emp.dao.EmpDAO;
import com.iii.emp.service.EmpService;
import com.iii.emp.vo.EmpVO;

@Service("empService")
@Transactional
public class EmpServiceImpl implements EmpService {

	@Autowired(required = true)
	@Qualifier("empDAO")
	private EmpDAO empDAO;

	// transactional default : if hava error rollback
	@Transactional(propagation = Propagation.REQUIRED)
	@Override
	public EmpVO addEmp(EmpVO empVO) {
		return empDAO.insert(empVO);
	}

	// default
	@Transactional(propagation = Propagation.REQUIRED)
	@Override
	public EmpVO updateEmp(EmpVO empVO) {
		return empDAO.update(empVO);
	}

	@Override
	public EmpVO getEmp(Integer empno) {
		return empDAO.getEmp(empno);
	}

	@Override
	public List<EmpVO> getEmps() {
		return empDAO.getEmps();
	}
	
	@Override
	public void delete(Integer empno) {
		empDAO.delete(empno);
	}

}
