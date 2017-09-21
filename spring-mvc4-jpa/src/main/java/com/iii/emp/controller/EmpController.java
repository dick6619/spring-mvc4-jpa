package com.iii.emp.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.iii.emp.domain.DeptVO;
import com.iii.emp.domain.EmpVO;
import com.iii.emp.service.DeptService;
import com.iii.emp.service.EmpService;

/**
 * 1. project root + /employee : call this controller
 * 2. project root + /employee + /... : do URI mapping，call method
 * 3. and this controller access views
 */
@Controller
@RequestMapping("/employee")
public class EmpController {

	@Resource
	private EmpService empService;
	@Resource
	private DeptService deptService;
	
	@GetMapping("/emps")
	public String getEmps(Model model) {
		model.addAttribute("emps", empService.getEmps());
		return "emp/emps";
	}

	@GetMapping("/editEmpView/{empno}")
	public ModelAndView getEditEmpForm(@PathVariable("empno") String empno) {
		// from view
		EmpVO eParam = new EmpVO();
		eParam.setEmpno(Integer.valueOf(empno));
		// query command and return edit model
		ModelAndView model = new ModelAndView("emp/editEmp");
		model.addObject("emp", empService.getEmp(eParam));
		model.addObject("depts", deptService.getDepts());
		return model;
	}

	@PostMapping("/editEmp")
	public ModelAndView editEmpVO(@ModelAttribute EmpVO empParam, @ModelAttribute DeptVO deptParam) {
		// from view
		empParam.setDeptVO(deptParam);
		// update command
		empService.updateEmp(empParam);
		// return model
		ModelAndView model = new ModelAndView("emp/emps");
		model.addObject("emps", empService.getEmps());
		return model;
	}

	@PostMapping("/addEmp")
	public ModelAndView addEmpVO(@ModelAttribute EmpVO empParam, @ModelAttribute DeptVO deptParam) {
		// from view
		empParam.setDeptVO(deptParam);
		// add command
		empService.addEmp(empParam);
		// return model
		ModelAndView model = new ModelAndView("emp/emps");
		model.addObject("emps", empService.getEmps());
		return model;
	}

	@PostMapping("/deleteEmp")
	public ModelAndView deleteEmp(@RequestParam(name = "empno") String empno) {
		// from view
		EmpVO eParam = new EmpVO();
		eParam.setEmpno(Integer.valueOf(empno));
		// delete command
		empService.delete(eParam);
		// return model
		ModelAndView model = new ModelAndView("emp/emps");
		model.addObject("emps", empService.getEmps());
		return model;
	}

}
