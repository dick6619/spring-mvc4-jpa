package com.iii.ui.controller;

import javax.annotation.Resource;

import org.json.JSONArray;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.iii.emp.model.EmpVO;
import com.iii.emp.service.EmpService;

@Controller
@RequestMapping("/test")
public class TestController {

	@Resource(name = "empService")
	private EmpService empService;

	/**
	 * 測試
	 * */
	@GetMapping(value = "/json", produces = "application/json")
	@ResponseBody
	public String getEmps() throws Exception {
		JSONArray jArr = new JSONArray();
		for (EmpVO empVO : empService.getEmps()) {
			jArr.put(empVO.toJSON());
		}
		return jArr.toString();
	}

}
