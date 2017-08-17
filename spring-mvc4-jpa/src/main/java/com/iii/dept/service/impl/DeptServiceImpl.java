package com.iii.dept.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.iii.dept.dao.DeptDAO;
import com.iii.dept.domain.DeptVO;
import com.iii.dept.service.DeptService;

@Service("deptService")
@Transactional
public class DeptServiceImpl implements DeptService {

	@Resource(name = "deptDAO")
	private DeptDAO deptDAO;

	@Override
	public List<DeptVO> getDepts() {
		return deptDAO.getDepts();
	}

}
