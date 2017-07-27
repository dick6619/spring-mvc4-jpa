package com.iii.emp.model.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class EmpValidatorJSR303 implements ConstraintValidator<Sal, Object> { // Object
																				// 為要驗證欄位的型態

	@Override
	public void initialize(Sal salTag) {
		// TODO Auto-generated method stub
		// 初始化

	}

	// Object 同上
	@Override
	public boolean isValid(Object sal, ConstraintValidatorContext arg1) {
		if (sal instanceof Double) {

			Double d = (Double) sal;
            // 測試而已
			if (d.equals(0.0))
				return false;
		}
		return true;
	}

}
