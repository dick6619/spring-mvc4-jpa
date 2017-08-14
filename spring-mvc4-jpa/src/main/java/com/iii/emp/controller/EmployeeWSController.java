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
import com.iii.emp.model.EmpVO;
import com.iii.emp.service.EmpService;

@Controller
@RequestMapping("/rest")
public class EmployeeWSController {

	@Resource(name = "empService")
	private EmpService empService;

	/**
	 * get all employee : ResponseEntity gson
	 */
	@GetMapping(value = "/json1", produces = "application/json")
	public ResponseEntity<String> getEmps1() throws Exception {
		// HttpHeaders headers = new HttpHeaders();
		Gson gson = new Gson();
		return new ResponseEntity<>(gson.toJson(empService.getEmps()), HttpStatus.OK);
	}

	/**
	 * get all employee : ResponseBody gson
	 */
	@GetMapping(value = "/json2", produces = "application/json; charset=UTF-8")
	public @ResponseBody String getEmps2() throws Exception {
		Gson gson = new Gson();
		return gson.toJson(empService.getEmps());
	}
	
	/**
	 * get all employee : ResponseBody jackson
	 */
	@GetMapping(value = "/json3", produces = "application/json")
	public @ResponseBody List<EmpVO> getEmps3() throws Exception {
		return empService.getEmps();
	}

	/**
	 * get employee
	 */
	@GetMapping(value = "/json4/{empno}", produces = "application/json")
	public @ResponseBody String getEmp4(@PathVariable("empno") String empno) {
		Gson gson = new Gson();
		return gson.toJson(empService.getEmp(Integer.valueOf(empno)));
	}
}
