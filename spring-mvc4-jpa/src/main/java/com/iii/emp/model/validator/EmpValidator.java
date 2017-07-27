package com.iii.emp.model.validator;

import org.apache.commons.lang3.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.iii.emp.model.EmpVO;
/**
 * spring validation
 * */
public class EmpValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		//
		return EmpVO.class.equals(clazz);
	}

	@Override
	public void validate(Object obj, Errors errors) {
		EmpVO empVO = (EmpVO) obj;

		// 1. 使用ValidationUtils的方法．簡單判別是否為null或空字串
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "ename", "valid.ename");
		
		// 2. 自行撰寫邏輯判斷是否錯誤
		if (StringUtils.isBlank(empVO.getEname())) {
			errors.rejectValue("ename", "valid.ename");
		}
		// 3. 自行判斷於properties negativeValue{0}自行塞入定義訊息
		if (StringUtils.isBlank(empVO.getEname())) {
			errors.rejectValue("ename", "negativeValue", new Object[]{"'ename'"}, "ename can't be empty");
		}

	}

}
