package com.iii.emp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.iii.emp.dao.DeptDAO;
import com.iii.emp.domain.DeptVO;
import com.iii.emp.service.DeptService;

@Service
@Transactional
public class DeptServiceImpl implements DeptService {

	@Autowired
	private DeptDAO deptDAO;

	@Override
	public List<DeptVO> getDepts() {
		return deptDAO.getDepts();
	}

}
