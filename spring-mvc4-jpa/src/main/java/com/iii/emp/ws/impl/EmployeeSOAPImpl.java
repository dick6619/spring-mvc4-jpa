package com.iii.emp.ws.impl;

import javax.annotation.Resource;
import javax.jws.WebService;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.iii.emp.domain.EmpVO;
import com.iii.emp.enumeration.EmpError;
import com.iii.emp.service.EmpService;
import com.iii.emp.ws.EmployeeSOAP;
import com.iii.emp.ws.domain.EmpInput;
import com.iii.emp.ws.domain.EmpOutput;
import com.iii.framework.core.exception.ServiceException;

@Service
@WebService(endpointInterface = "com.iii.emp.ws.EmployeeSOAP") // , serviceName = "empService", targetNamespace =
																// "http://service.soap"
public class EmployeeSOAPImpl implements EmployeeSOAP {

	private static Logger logger = Logger.getLogger(EmployeeSOAPImpl.class);

	@Resource
	EmpService empService;

	@Override
	public EmpOutput getEmp(EmpInput input) {
		//
		EmpOutput empOutput = new EmpOutput();
		try {
			// parameter
			EmpVO eParam = new EmpVO();
			eParam.setEmpno(input.getEmpno());
			// convert to output object
			BeanUtils.copyProperties(empOutput, empService.getEmp(eParam));
			
		} catch (ServiceException e) {
			// error code
			empOutput.setStatus(e.getError().getCode());
			// record
			logger.debug("EmployeeSOAPImpl...getEmp(..)" + e);
			
		} catch (Exception e) {
			// error code
			empOutput.setStatus(EmpError.UNDEFINED_ERROR.getCode());
			// record
			logger.debug("EmployeeSOAPImpl...getEmp(..)" + e);
		}
		return empOutput;
	}

}
