package com.iii.ui.ws.restful;

import javax.annotation.Resource;

import org.json.JSONArray;
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
@RequestMapping("/test")
public class EmployeeWS {

	@Resource(name = "empService")
	private EmpService empService;

	/**
	 * get all employee : RequestBody
	 */
	@GetMapping(value = "/json", produces = "application/json")
	public @ResponseBody String getEmps() throws Exception {
		JSONArray jArr = new JSONArray();
		if (empService.getEmps() != null) {
			for (EmpVO empVO : empService.getEmps()) {
				jArr.put(empVO.toJSON());
			}
		}
		return jArr.toString();
	}

	/**
	 * get all employee : ResponseEntity
	 */
	@GetMapping(value = "/json2", produces = "application/json")
	public ResponseEntity<String> getEmps2() throws Exception {
		JSONArray jArr = new JSONArray();
		// .... header
		if (empService.getEmps() != null) {
			for (EmpVO empVO : empService.getEmps()) {
				jArr.put(empVO.toJSON());
			}
		}
		return new ResponseEntity<>(jArr.toString(), HttpStatus.OK);
	}

	/**
	 * get all employee : use google Gson
	 * toJson, fromJson POJO and JSON可以方便地互相轉換．連EmpVO內的DeptVO都能解析
	 */
	@GetMapping(value = "/json3", produces = "application/json")
	public @ResponseBody String getEmps3() throws Exception {
		Gson gson = new Gson();
		return gson.toJson(empService.getEmps());
	}

	/**
	 * get employee
	 */
	@GetMapping(value = "/json4/{empno}", produces = "application/json")
	public @ResponseBody String getEmp(@PathVariable("empno") Integer empno) throws Exception {
		JSONArray jArr = new JSONArray();

		if (empService.getEmp(empno) != null) {
			jArr.put(empService.getEmp(empno).toJSON());
		}
		return jArr.toString();
	}

	/**
	 * get employee use gson
	 */
	@GetMapping(value = "/json5/{empno}", produces = "application/json")
	public @ResponseBody String getEmp1(@PathVariable("empno") Integer empno) throws Exception {
		Gson gson = new Gson();
		return gson.toJson(empService.getEmp(empno));
	}

}
