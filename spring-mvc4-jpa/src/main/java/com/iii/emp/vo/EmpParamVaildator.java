package com.iii.emp.vo;

import org.apache.commons.lang3.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class EmpParamVaildator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return EmpVO.class.equals(clazz);
	}

	@Override
	public void validate(Object obj, Errors errors) {
		EmpVO empVO = (EmpVO) obj;

		// 1. 使用ValidationUtils, 是null或空字串
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "ename", "valid.ename");
		// 2. 自行判斷使用properties內的錯誤訊息
		if (StringUtils.isBlank(empVO.getEname())) {
			errors.rejectValue("ename", "valid.ename");
		}
		// 3. 自行判斷並於此自訂
		if (StringUtils.isBlank(empVO.getEname())) {
			errors.rejectValue("ename", "negativeValue", new Object[]{"'ename'"}, "ename can't be empty");
		}

	}

}
