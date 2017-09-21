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
		// return edit view(getEmp)
		ModelAndView model = new ModelAndView("emp/editEmp");
		model.addObject("emp", empService.getEmp(eParam));
		model.addObject("depts", deptService.getDepts());
		return model;
	}

	@PostMapping("/editEmp")
	public ModelAndView editEmpVO(@ModelAttribute EmpVO empParam, @ModelAttribute DeptVO dParam) {
		// from view
		empParam.setDeptVO(dParam);
		// update
		empService.updateEmp(empParam);
		// return model
		ModelAndView model = new ModelAndView("emp/emps");
		model.addObject("emps", empService.getEmps());
		return model;
	}

	@PostMapping("/addEmp")
	public ModelAndView addEmpVO(@ModelAttribute EmpVO empParam, @ModelAttribute DeptVO dParam) {
		// from view
		empParam.setDeptVO(dParam);
		// add
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
		// delete
		empService.delete(eParam);
		// return model
		ModelAndView model = new ModelAndView("emp/emps");
		model.addObject("emps", empService.getEmps());
		return model;
	}

}
