package com.iii.ui.controller;

//import java.sql.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.iii.dept.model.DeptVO;
import com.iii.emp.model.EmpVO;
import com.iii.emp.service.EmpService;

/**
 * 
 * 專案路徑 + emp = call this controller 並進行URI mapping，決定要呼叫哪個方法，由此 controller 來存取view資源
 * 
 * @author LIN
 * */
@Controller
@RequestMapping("/emp")
public class EmpController {

	// 等於 @Autowired + @Qualifier("") 但不為Spring的組件
	@Resource(name = "empService")
	private EmpService empService;

	// read all employee
	@GetMapping("/emps")
	public ModelAndView getEmps() {
		ModelAndView model = new ModelAndView("emps");
		List<EmpVO> list = empService.getEmps();
		model.addObject("emps", list);
		return model;
	}

	// go to edit view
	@GetMapping("/editEmpView/{empno}")
	public ModelAndView getEditEmpForm(@PathVariable("empno") String empno) {
		ModelAndView model = new ModelAndView("editEmp");
		EmpVO emp = empService.getEmp(Integer.valueOf(empno));
		model.addObject("emp", emp);
		return model;
	}

	// update employee and go all employee view
	@RequestMapping(value = "editEmp", method = RequestMethod.POST)
	public ModelAndView editEmpVO( 
			// 在參數前加@valid 進入此方法前就會驗證
			@ModelAttribute @Valid EmpVO empParam, @ModelAttribute DeptVO deptParam) {
		//
		ModelAndView model = new ModelAndView("emps");
		empParam.setDeptVO(deptParam);
		//
		EmpVO empvo = empService.updateEmp(empParam);
		//
		if (empvo != null) {
			model.addObject("saveSuccess", "emp Added SuccessFully:" + empvo.getEname());
		} else {
			model.addObject("saveError", "emp creation failed");
		}
		//
		List<EmpVO> list = empService.getEmps();
		model.addObject("emps", list);
		return model;
	}

	// create new employee and go to all employee view
	@RequestMapping(value = "addEmp", method = RequestMethod.POST)
	public ModelAndView addEmpVO(@ModelAttribute @Valid EmpVO empParam, @ModelAttribute DeptVO deptParam) {
		ModelAndView model = new ModelAndView("emps");
		empParam.setDeptVO(deptParam);
		EmpVO empvo = empService.addEmp(empParam);
		if (empvo != null) {
			model.addObject("saveSuccess", "Customer Added SuccessFully:" + empvo.getEname());
		} else {
			model.addObject("saveError", "Customer creation failed");
		}
		List<EmpVO> list = empService.getEmps();
		model.addObject("emps", list);
		return model;
	}

	// delete
	@GetMapping("/deleteEmp/{empno}")
	public ModelAndView deleteEmp(@PathVariable("empno") String empno) {
		ModelAndView model = new ModelAndView("emps");
		empService.delete(Integer.valueOf(empno));
		List<EmpVO> list = empService.getEmps();
		model.addObject("emps", list);
		return model;
	}

}
