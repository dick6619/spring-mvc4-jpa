package com.iii.emp.ws.soap.impl;

import javax.annotation.Resource;
import javax.jws.WebService;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.log4j.Logger;
//import org.springframework.stereotype.Service;

import com.iii.emp.domain.EmpVO;
import com.iii.emp.enumeration.EmpError;
import com.iii.emp.service.EmpService;
import com.iii.emp.ws.soap.EmpSOAP;
import com.iii.emp.ws.soap.domain.EmpInput;
import com.iii.emp.ws.soap.domain.EmpOutput;
import com.iii.framework.core.exception.ServiceException;

//@Service
@WebService(endpointInterface = "com.iii.emp.ws.soap.EmpSOAP") // , serviceName = "empService", targetNamespace =
																// "http://service.soap"
public class EmpSOAPImpl implements EmpSOAP {

	private static Logger logger = Logger.getLogger(EmpSOAPImpl.class);

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
