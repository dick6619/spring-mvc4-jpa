package com.iii.emp.ws;


import javax.jws.WebMethod;
import javax.jws.WebService;

import com.iii.emp.ws.domain.EmpInput;
import com.iii.emp.ws.domain.EmpOutput;

@WebService
public interface EmployeeSOAP {
	@WebMethod
	EmpOutput getEmp(EmpInput input);
}
