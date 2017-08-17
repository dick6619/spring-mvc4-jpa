package com.iii.emp.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.iii.dept.model.DeptVO;
import com.iii.dept.service.DeptService;
import com.iii.emp.model.EmpVO;
import com.iii.emp.service.EmpService;

/**
 * 專案路徑 + /employee = call this controller 進行URI mapping，決定呼叫哪個方法，由此controller
 * 來存取view資源
 */
@Controller
@RequestMapping("/employee")
public class EmployeeController {

	@Resource(name = "empService")
	private EmpService empService;

	@Resource(name = "deptService")
	private DeptService deptService;

	/**
	 * All employee view
	 */
	@GetMapping("/emps")
	public ModelAndView getEmps() {
		ModelAndView model = new ModelAndView("emp/emps");
		model.addObject("emps", empService.getEmps());
		return model;
	}

	/**
	 * Go to edit employee view
	 */
	@GetMapping("/editEmpView/{empno}")
	public ModelAndView getEditEmpForm(@PathVariable("empno") String empno) {
		ModelAndView model = new ModelAndView("emp/editEmp");
		model.addObject("emp", empService.getEmp(Integer.valueOf(empno)));
		return model;
	}

	/**
	 * Update employee and go to all employee view
	 */
	@RequestMapping(value = "editEmp", method = RequestMethod.POST)
	public ModelAndView editEmpVO(@ModelAttribute EmpVO empParam, @ModelAttribute DeptVO deptParam) {
		empParam.setDeptVO(deptParam);
		empService.updateEmp(empParam);
		ModelAndView model = new ModelAndView("emp/emps");
		model.addObject("emps", empService.getEmps());
		return model;
	}

	/**
	 * Create new employee and go to all employee view
	 */
	@RequestMapping(value = "addEmp", method = RequestMethod.POST)
	public ModelAndView addEmpVO(@ModelAttribute EmpVO empParam, @ModelAttribute DeptVO deptParam) {
		empParam.setDeptVO(deptParam);
		empService.addEmp(empParam);
		ModelAndView model = new ModelAndView("emp/emps");
		model.addObject("emps", empService.getEmps());
		return model;
	}

	/**
	 * delete
	 */
	@GetMapping("/deleteEmp/{empno}")
	public ModelAndView deleteEmp(@PathVariable("empno") String empno) {
		empService.delete(Integer.valueOf(empno));
		ModelAndView model = new ModelAndView("emp/emps");
		model.addObject("emps", empService.getEmps());
		return model;
	}

}
