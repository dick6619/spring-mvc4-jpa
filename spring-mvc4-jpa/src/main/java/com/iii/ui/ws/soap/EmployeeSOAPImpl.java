package com.iii.ui.ws.soap;

import javax.jws.WebService;
import javax.xml.ws.WebServiceClient;

import com.iii.emp.model.EmpVO;

@WebService(endpointInterface = "")
@WebServiceClient(name = "")
public class EmployeeSOAPImpl implements EmployeeSOAP {

	@Override
	public EmpVO getEmp(EmpVO empVO) {
		// TODO Auto-generated method stub
		return null;
	}

}
