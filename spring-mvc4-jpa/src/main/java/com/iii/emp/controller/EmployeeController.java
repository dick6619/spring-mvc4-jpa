package com.iii.emp.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.iii.dept.domain.DeptVO;
import com.iii.dept.service.DeptService;
import com.iii.emp.domain.EmpVO;
import com.iii.emp.service.EmpService;

/**
 * 1. project root + /employee : call this controller
 * 2. project root + /employee + /... : do URI mapping，call method
 * 3. and this controller access views
 * 4. restful : Get= Read; Post= Create; Put= Update; Delete= delete; but...
 */
@Controller
@RequestMapping("/employee")
public class EmployeeController {

	@Resource(name = "empService")
	private EmpService empService;
	@Resource(name = "deptService")
	private DeptService deptService;
	
	@GetMapping("/emps")
	public ModelAndView getEmps() {
		ModelAndView model = new ModelAndView("emp/emps");
		model.addObject("emps", empService.getEmps());
		return model;
	}

	@GetMapping("/editEmpView/{empno}")
	public ModelAndView getEditEmpForm(@PathVariable("empno") String empno) {
		ModelAndView model = new ModelAndView("emp/editEmp");
		model.addObject("emp", empService.getEmp(Integer.valueOf(empno)));
		model.addObject("depts", deptService.getDepts());
		return model;
	}

	@PostMapping("/editEmp")
	public ModelAndView editEmpVO(@ModelAttribute EmpVO empParam, @ModelAttribute DeptVO deptParam) {
		empParam.setDeptVO(deptParam);
		empService.updateEmp(empParam);
		ModelAndView model = new ModelAndView("emp/emps");
		model.addObject("emps", empService.getEmps());
		return model;
	}

	@PostMapping("/addEmp")
	public ModelAndView addEmpVO(@ModelAttribute EmpVO empParam, @ModelAttribute DeptVO deptParam) {
		empParam.setDeptVO(deptParam);
		empService.addEmp(empParam);
		ModelAndView model = new ModelAndView("emp/emps");
		model.addObject("emps", empService.getEmps());
		return model;
	}

	@PostMapping("/deleteEmp")
	public ModelAndView deleteEmp(@RequestParam(name = "empno") String empno) {
		empService.delete(Integer.valueOf(empno));
		ModelAndView model = new ModelAndView("emp/emps");
		model.addObject("emps", empService.getEmps());
		return model;
	}

}
