package com.iii.emp.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.iii.emp.dao.DeptDAO;
import com.iii.emp.domain.DeptVO;
import com.iii.emp.service.DeptService;

@Service
@Transactional
public class DeptServiceImpl implements DeptService {

	private static Logger logger = Logger.getLogger(DeptServiceImpl.class);
	
	@Resource
	private DeptDAO deptDAO;

	@Override
	public List<DeptVO> getDepts() {
		try {
			return deptDAO.getDepts();
		} catch (Exception e) {
			logger.debug("DeptServiceImpl...getDepts()" + e);
			throw e;
		}

	}

}
