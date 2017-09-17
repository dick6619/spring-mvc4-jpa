package com.iii.ui.controller;

//import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.iii.dept.vo.DeptVO;
import com.iii.emp.service.EmpService;
import com.iii.emp.vo.EmpVO;

@Controller
@RequestMapping("/emp")
public class EmpController {

	@Autowired(required = true)
	@Qualifier("empService")
	private EmpService empService;
	/*
	 * url會先找controller再找config路徑
	 * 說明: header.jsp 有段連結會連結到 config內設置的一段路徑emp/empForm.action 再轉到此controller 的addEmp
	 * 把以下註解打開就會先對應以下方法而不到config
	 */
	// home
	// @GetMapping("*")
	// public String getHome() {
	// return "home";
	// }

	// all emps
	@GetMapping("/emps")
	public ModelAndView getEmps() {
		ModelAndView model = new ModelAndView("emps");
		List<EmpVO> list = empService.getEmps();
		model.addObject("emps", list);
		return model;
	}

	// go to emp edit view
	@GetMapping("/editEmpView/{empno}")
	public ModelAndView getEditEmpForm(@PathVariable("empno") String empno) {
		ModelAndView model = new ModelAndView("editEmp");
		EmpVO emp = empService.getEmp(Integer.valueOf(empno));
		model.addObject("emp", emp);
		return model;
	}

	// 中文字加密過變長，spring先後再?
	// value可以不寫，會自動對應前端的name去set，required沒有傳也不要錯就設為false
	// update and go to all emps view
	// @RequestMapping(value = "editEmp", method = RequestMethod.POST)
	// public ModelAndView editEmpVO(
	// @RequestParam(value = "empno") Integer empno,
	// @RequestParam("ename" required = false) String ename,
	// @RequestParam("job") String job,
	// @RequestParam("hiredate") Date hiredate,
	// @RequestParam("sal") Double sal,
	// @RequestParam("comm") Double comm,
	// @RequestParam("deptno") Integer deptno
	// ) {
	// ModelAndView model = new ModelAndView("emps");
	// EmpVO empParam = new EmpVO();
	// empParam.setEmpno(empno);
	// empParam.setEname(ename);
	// empParam.setJob(job);
	// empParam.setHiredate(hiredate);
	// empParam.setSal(sal);
	// empParam.setComm(comm);
	// DeptVO deptParam = new DeptVO();
	// deptParam.setDeptno(deptno);
	// empParam.setDeptVO(deptParam);
	// //
	// EmpVO empvo = empService.updateEmp(empParam);
	// if (empvo != null) {
	// model.addObject("saveSuccess", "emp Added SuccessFully:" +
	// empvo.getEname());
	// } else {
	// model.addObject("saveError", "emp creation failed");
	// }
	// //
	// List<EmpVO> list = empService.getEmps();
	// model.addObject("emps", list);
	// return model;
	//
	// }

	// update emp and go emps view
	@RequestMapping(value = "editEmp", method = RequestMethod.POST)
	public ModelAndView editEmpVO(
			// 自動將頁面上的參數注入POJO內
			@ModelAttribute EmpVO empParam, @ModelAttribute DeptVO deptParam) {
		ModelAndView model = new ModelAndView("emps");
		empParam.setDeptVO(deptParam);
		EmpVO empvo = empService.updateEmp(empParam);
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

	// add emp and go to emps view
	@RequestMapping(value = "addEmp", method = RequestMethod.POST)
	public ModelAndView addEmpVO(@ModelAttribute EmpVO empParam, @ModelAttribute DeptVO deptParam) {
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
