package com.iii.emp.model.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class SalValidatorJSR303 implements ConstraintValidator<Sal, Double> { // Double
																				// 為要驗證欄位的型態，
																				// Sal為要使用得類別

	@Override
	public void initialize(Sal sal) {
		//
		// 類別初始化

	}

	// Double 同上一致為要驗證的欄位
	/**
	 * 經測試，前端請求參數近來，controller呼叫service, service呼叫dao, dao對資料庫做請求這段都還是會做． 
	 * 而由dao將資料傳回service也會做, 再由service到最後contoller，才會驗證有被此標註標註的VO(到最後一段)
	 * */
	@Override
	public boolean isValid(Double value, ConstraintValidatorContext arg1) {

		// true 沒錯
		if (Sal.MIN <= value && value <= Sal.MAX) {
			return true;
		}
		// false 有錯
		return false;
	}

}
