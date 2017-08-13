package com.iii.emp.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.iii.dept.entity.DeptVO;
import com.iii.emp.entity.EmpVO;
import com.iii.emp.service.EmpService;

/**
 * 專案路徑 + /employee = call this controller 進行URI mapping，決定呼叫哪個方法，由此controller
 * 來存取view資源
 */
@Controller
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	@Qualifier("empService")
	private EmpService empService;

	/**
	 * All employee view
	 */
	@GetMapping("/emps")
	public ModelAndView getEmps() {
		ModelAndView model = new ModelAndView("emp/emps");
		List<EmpVO> list = empService.getEmps();
		model.addObject("emps", list);
		return model;
	}

	/**
	 * Go to edit employee view
	 */
	@GetMapping("/editEmpView/{empno}")
	public ModelAndView getEditEmpForm(@PathVariable("empno") String empno) {
		ModelAndView model = new ModelAndView("emp/editEmp");
		EmpVO emp = empService.getEmp(Integer.valueOf(empno));
		model.addObject("emp", emp);
		return model;
	}

	/**
	 * Update employee and go to all employee view
	 */
	@RequestMapping(value = "editEmp", method = RequestMethod.POST)
	public ModelAndView editEmpVO(@ModelAttribute @Valid EmpVO empParam, @ModelAttribute DeptVO deptParam) {
		ModelAndView model = new ModelAndView("emp/emps");
		empParam.setDeptVO(deptParam);
		EmpVO empvo = empService.updateEmp(empParam);
		if (empvo != null) {
			model.addObject("saveSuccess", "emp Added SuccessFully:" + empvo.getEname());
		} else {
			model.addObject("saveError", "emp creation failed");
		}
		model.addObject("emps", empService.getEmps());
		return model;
	}

	/** 
	 * Create new employee and go to all employee view
	 * */
	@RequestMapping(value = "addEmp", method = RequestMethod.POST)
	public ModelAndView addEmpVO(@ModelAttribute @Valid EmpVO empParam, @ModelAttribute DeptVO deptParam) {
		ModelAndView model = new ModelAndView("emp/emps");
		empParam.setDeptVO(deptParam);
		EmpVO empvo = empService.addEmp(empParam);
		if (empvo != null) {
			model.addObject("saveSuccess", "Customer Added SuccessFully:" + empvo.getEname());
		} else {
			model.addObject("saveError", "Customer creation failed");
		}
		model.addObject("emps", empService.getEmps());
		return model;
	}

	/**
	 * delete 
	 *  */
	@GetMapping("/deleteEmp/{empno}")
	public ModelAndView deleteEmp(@PathVariable("empno") String empno) {
		ModelAndView model = new ModelAndView("emp/emps");
		empService.delete(Integer.valueOf(empno));
		model.addObject("emps", empService.getEmps());
		return model;
	}

}
