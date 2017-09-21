package com.iii.emp.ws.rest;

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
import com.iii.emp.service.EmpService;

@Controller
@RequestMapping("/restWS")
public class EmpRestWS {

	@Resource
	private EmpService empService;

	@GetMapping(value = "/getEmps1")
	public ResponseEntity<String> getEmps1() {
		// HttpHeaders headers = new HttpHeaders();
		Gson gson = new Gson();
		return new ResponseEntity<>(gson.toJson(empService.getEmps()), HttpStatus.OK);
	}

	@GetMapping(value = "/getEmps2")
	public @ResponseBody List<EmpVO> getEmps3() {
		return empService.getEmps();
	}

	@GetMapping(value = "/getEmp/{empno}")
	public @ResponseBody EmpVO getEmp4(@PathVariable("empno") String empno) {
		EmpVO eParam = new EmpVO();
		eParam.setEmpno(Integer.valueOf(empno));
		return empService.getEmp(eParam);

	}

	@GetMapping(value = "/getEmpLike/{ename}")
	public @ResponseBody List<EmpVO> getEmp5(@PathVariable("ename") String ename) {
		EmpVO eParam = new EmpVO();
		eParam.setEname(ename);
		return empService.getEmpBySqlLike(eParam);
	}

}
