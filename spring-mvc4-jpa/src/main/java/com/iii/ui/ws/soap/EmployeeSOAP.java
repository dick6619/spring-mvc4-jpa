package com.iii.ui.ws.soap;


import javax.jws.WebMethod;
import javax.jws.WebService;

import com.iii.emp.model.EmpVO;

@WebService
public interface EmployeeSOAP {
	@WebMethod
	EmpVO getEmp(Integer empno);

}
