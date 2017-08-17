package com.iii.emp.ws.impl;

import javax.annotation.Resource;
import javax.jws.WebService;

import org.springframework.stereotype.Service;

import com.iii.emp.domain.EmpVO;
import com.iii.emp.service.EmpService;
import com.iii.emp.ws.EmployeeSOAP;

@Service
@WebService(endpointInterface = "com.iii.emp.ws.EmployeeSOAP")
public class EmployeeSOAPImpl implements EmployeeSOAP {

	@Resource(name = "empService")
	EmpService empService;

	@Override
	public EmpVO getEmp(Integer empno) {
		return empService.getEmp(empno);
	}

}
