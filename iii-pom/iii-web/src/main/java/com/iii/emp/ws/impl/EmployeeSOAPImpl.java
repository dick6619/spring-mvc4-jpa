package com.iii.emp.ws.impl;

import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.iii.emp.entity.EmpVO;
import com.iii.emp.service.EmpService;
import com.iii.emp.ws.EmployeeSOAP;

@Service
@WebService(endpointInterface = "com.iii.emp.ws.EmployeeSOAP")
public class EmployeeSOAPImpl implements EmployeeSOAP {

	@Autowired
	@Qualifier("empService")
	EmpService empService;

	@Override
	public EmpVO getEmp(Integer empno) {
		return empService.getEmp(empno);
	}

}
