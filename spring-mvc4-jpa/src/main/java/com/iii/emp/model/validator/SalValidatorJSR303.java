package com.iii.emp.model.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

//Double為要驗證欄位的型態
public class SalValidatorJSR303 implements ConstraintValidator<Sal, Double> {

	@Override
	public void initialize(Sal sal) {
	}

	/**
	 * 經測試，當屬性成員有被標註，Controller -> Service -> DAO, DAO對資料庫做請求交易都還是會做．
	 * 而最後資料回傳到Controller，才會開始做驗證，如一開始就在傳入參數的方法前面加@Valid，則一開始就會做
	 */
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
