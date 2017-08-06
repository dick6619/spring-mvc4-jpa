package com.iii.ui.ws.soap;

import javax.annotation.Resource;
import javax.jws.WebService;

import org.springframework.stereotype.Service;

import com.iii.emp.model.EmpVO;
import com.iii.emp.service.EmpService;

@Service
// targetNamespace = "" ???
@WebService(serviceName = "EmployeeSOAPClient", endpointInterface = "com.iii.ui.ws.soap.EmployeeSOAP")
public class EmployeeSOAPImpl implements EmployeeSOAP {

	@Resource(name = "empService")
	EmpService empService;

	@Override
	public EmpVO getEmp(Integer empno) {
		return empService.getEmp(empno);
	}

}
