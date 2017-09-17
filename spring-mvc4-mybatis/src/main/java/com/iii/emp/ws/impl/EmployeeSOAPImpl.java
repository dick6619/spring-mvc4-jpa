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
@WebService(endpointInterface = "com.iii.emp.ws.EmployeeSOAP")
public class EmployeeSOAPImpl implements EmployeeSOAP {

	private static Logger logger = Logger.getLogger(EmployeeSOAPImpl.class);

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
