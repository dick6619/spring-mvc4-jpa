package com.iii.emp.ws.impl;

import javax.annotation.Resource;
import javax.jws.WebService;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.stereotype.Service;

import com.iii.emp.domain.EmpVO;
import com.iii.emp.enumeration.EmpError;
import com.iii.emp.service.EmpService;
import com.iii.emp.ws.EmployeeSOAP;
import com.iii.emp.ws.domain.EmpInput;
import com.iii.emp.ws.domain.EmpOutput;

@Service
@WebService(endpointInterface = "com.iii.emp.ws.EmployeeSOAP") // , serviceName = "empService", targetNamespace = "http://service.soap"
public class EmployeeSOAPImpl implements EmployeeSOAP {

	@Resource(name = "empService")
	EmpService empService;

	@Override
	public EmpOutput getEmp(EmpInput input) {
		//
		EmpOutput empOutput = new EmpOutput();
		//
		if (input.getEmpno() == null) {
			empOutput.setStatus(EmpError.PARAM_ERROR.getCode());
		}
		try {
			//
			EmpVO ePraram = new EmpVO();
			ePraram.setEmpno(input.getEmpno());
			EmpVO empVO = empService.getEmp(ePraram);
			//
			if (empVO == null) {
				empOutput.setStatus(EmpError.EMPTY_DATA.getCode());
			}
			BeanUtils.copyProperties(empOutput, empVO);
		} catch (Exception e) {
			empOutput.setStatus(EmpError.UNDEFINED_ERROR.getCode());
		}
		return empOutput;
	}

}
