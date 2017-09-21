package com.iii.emp.ws.rest;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.iii.emp.domain.EmpVO;
import com.iii.emp.service.EmpService;


@RestController
@RequestMapping("/restWS2")
public class EmpRestWS {

	@Resource
	private EmpService empService;

	@GetMapping("/getEmps")
	public List<EmpVO> getEmps() {
		return empService.getEmps();
	}

	@GetMapping("/getEmp/{empno}")
	public EmpVO getEmp(@PathVariable("empno") String empno) {
		EmpVO eParam = new EmpVO();
		eParam.setEmpno(Integer.valueOf(empno));
		return empService.getEmp(eParam);
	}
	
	@GetMapping(value = "/getLikeEmp/{ename}")
	public List<EmpVO> getLikeEmp(@PathVariable("ename") String ename) {
		EmpVO eParam = new EmpVO();
		eParam.setEname(ename);
		return empService.getEmpBySqlLike(eParam);
	}

}
