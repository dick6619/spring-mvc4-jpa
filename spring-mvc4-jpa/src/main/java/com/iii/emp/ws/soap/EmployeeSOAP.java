package com.iii.emp.ws.soap;


import javax.jws.WebMethod;
import javax.jws.WebService;

import com.iii.emp.ws.soap.domain.EmpInput;
import com.iii.emp.ws.soap.domain.EmpOutput;

@WebService
public interface EmployeeSOAP {
	@WebMethod
	EmpOutput getEmp(EmpInput input);
}
