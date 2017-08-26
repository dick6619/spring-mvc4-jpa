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

	/**
	 * 1. 錯誤應該在empService內噴出ServiceException, 在由介接程式將ServiceException轉為錯誤代碼。傳於外機關。
	 * 2. empService內的錯誤訊息供內部人員除錯。程式須更改。這邊程式碼會在短
	 * 3. 應該設計為emp為一個module, ws為一個module
	 * */
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
			EmpVO empVO = empService.getEmp(input.getEmpno());
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
