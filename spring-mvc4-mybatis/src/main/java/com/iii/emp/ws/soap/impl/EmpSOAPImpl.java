package com.iii.emp.ws.soap.impl;

import javax.annotation.Resource;
import javax.jws.WebService;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.log4j.Logger;

import com.iii.emp.domain.EmpVO;
import com.iii.emp.enumeration.EmpError;
import com.iii.emp.service.EmpService;
import com.iii.emp.ws.soap.EmpSOAP;
import com.iii.emp.ws.soap.domain.EmpInput;
import com.iii.emp.ws.soap.domain.EmpOutput;
import com.iii.framework.core.exception.ServiceException;

@WebService(endpointInterface = "com.iii.emp.ws.soap.EmpSOAP")
public class EmpSOAPImpl implements EmpSOAP {

	private static Logger logger = Logger.getLogger(EmpSOAPImpl.class);

	@Resource
	EmpService empService;

	@Override
	public EmpOutput getEmp(EmpInput input) {
		// protocol output object
		EmpOutput empOutput = new EmpOutput();
		try {
			// protocol input object convert query parameter
			EmpVO ePraram = new EmpVO();
			ePraram.setEmpno(input.getEmpno());
			// query result convert to protocol output object
			BeanUtils.copyProperties(empOutput, empService.getEmp(ePraram));
		} catch (ServiceException e) {
			// return error code
			empOutput.setStatus(e.getError().getCode());
			// record exception
			logger.debug("EmployeeSOAPImpl...getEmp(..)" + e);
		} catch (Exception e) {
			// undefined error
			empOutput.setStatus(EmpError.UNDEFINED_ERROR.getCode());
			// record exception
			logger.debug("EmployeeSOAPImpl...getEmp(..)" + e);
		}
		return empOutput;
	}

}
