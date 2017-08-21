package com.iii.emp.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.iii.emp.domain.EmpVO;
import com.iii.emp.enumeration.EmpError;
import com.iii.emp.service.EmpService;
import com.iii.framework.core.exception.ServiceException;

@Controller
@RequestMapping("/restWS")
public class EmployeeWSController {

	@Resource(name = "empService")
	private EmpService empService;

	/**
	 * get all employee : ResponseEntity
	 */
	@GetMapping(value = "/getEmps1", produces = "application/json; charset=UTF-8")
	public ResponseEntity<String> getEmps1() throws Exception {
		// HttpHeaders headers = new HttpHeaders();
		Gson gson = new Gson();
		return new ResponseEntity<>(gson.toJson(empService.getEmps()), HttpStatus.OK);
	}

	/**
	 * get all employee : jackson converter since spring 3.2
	 */
	@GetMapping(value = "/getEmps2")
	public @ResponseBody List<EmpVO> getEmps3() throws Exception {
		return empService.getEmps();
	}

	/**
	 * get employee
	 */
	@GetMapping(value = "/getEmp/{empno}")
	public @ResponseBody EmpVO getEmp4(@PathVariable("empno") String empno) {
		EmpVO empVO;
		try {
			empVO = empService.getEmp(Integer.valueOf(empno));
		} catch (Exception e) {
			throw new ServiceException(EmpError.UNDEFINED_ERROR);
		}
		if (empVO == null) {
			throw new ServiceException(EmpError.EMPTY_DATA);
		}
		return empVO;

	}

	/**
	 * get employees by like SQL
	 */
	@GetMapping(value = "/getEmpLike/{ename}")
	public @ResponseBody List<EmpVO> getEmp5(@PathVariable("ename") String ename) {
		return empService.getEmpBySqlLike(ename);
	}
	
	/**
	 * test RequestMapping default...  is all can
	 * */
	@RequestMapping(value = "/testDefault")
	public String testDefault() {
		return "hello";
	}

}
