package com.iii.emp.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.iii.emp.dao.EmpDAO;
import com.iii.emp.domain.EmpVO;
import com.iii.emp.enumeration.EmpError;
import com.iii.emp.service.EmpService;
import com.iii.framework.core.exception.ServiceException;

@Service
@Transactional
public class EmpServiceImpl implements EmpService {

	private static Logger logger = Logger.getLogger(EmpServiceImpl.class);

	@Resource
	private EmpDAO empDAO;

	@Override
	public int addEmp(EmpVO eParam) {
		try {
			// parameter is correct?
			if (eParam == null) {
				throw new ServiceException(EmpError.PARAM_ERROR);
			}
			// add command
			int success = empDAO.insert(eParam);
			// is success?
			if (success != 1) {
				throw new ServiceException(EmpError.INSERT_ERROR);
			}
			return success;

		} catch (Exception e) {
			logger.debug("EmpServiceImpl...addEmp(..)" + e);
			throw e;
		}

	}

	@Override
	public EmpVO getEmp(EmpVO eParam) {
		try {
			// parameter is correct?
			if (eParam == null || eParam.getEmpno() == 0) {
				throw new ServiceException(EmpError.PARAM_ERROR);
			}
			// query command
			EmpVO emp = empDAO.getEmp(eParam);
			if (emp == null) {
				throw new ServiceException(EmpError.EMPTY_DATA);
			}
			return emp;
		} catch (Exception e) {
			logger.debug("EmpServiceImpl...getEmp(..)" + e);
			throw e;
		}
	}

	@Override
	public List<EmpVO> getEmps() {
		try {
			return empDAO.getEmps();
		} catch (Exception e) {
			logger.debug("EmpServiceImpl...getEmps()" + e);
			throw e;
		}

	}

	@Override
	public int updateEmp(EmpVO eParam) {
		try {
			// parameter is correct?
			if (eParam == null || eParam.getEmpno() == 0) {
				throw new ServiceException(EmpError.PARAM_ERROR);
			}
			// update command
			int success = empDAO.update(eParam);
			// is success?
			if (success != 1) {
				throw new ServiceException(EmpError.UPDATE_ERROR);
			}
			return success;

		} catch (Exception e) {
			logger.debug("EmpServiceImpl...update(..)" + e);
			throw e;
		}
	}

	@Override
	public int delete(EmpVO eParam) {
		try {
			// parameter is correct?
			if (eParam == null || eParam.getEmpno() == 0) {
				throw new ServiceException(EmpError.PARAM_ERROR);
			}
			// delete command
			int success = empDAO.delete(eParam);
			if (success != 1) {
				throw new ServiceException(EmpError.DELETE_ERROR);
			}
			return success;
		} catch (Exception e) {
			logger.debug("EmpServiceImpl...delete(..)" + e);
			throw e;
		}
	}

	@Override
	public List<EmpVO> getEmpBySqlLike(EmpVO eParam) {
		try {
			if (eParam == null || StringUtils.isBlank(eParam.getEname())) {
				throw new ServiceException(EmpError.PARAM_ERROR);
			}
			return empDAO.getEmpBySqlLike(eParam);
		} catch (Exception e) {
			logger.debug("EmpServiceImpl...getEmpBySqlLike(..)" + e);
			throw e;
		}

	}

}
