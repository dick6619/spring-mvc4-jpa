package com.iii.framework.core.validation.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.iii.framework.core.validation.DoubleNum;

//Double為要驗證欄位的型態
public class DoubleNumValidator implements ConstraintValidator<DoubleNum, Double> {

	private double min;
	private double max;

	@Override
	public void initialize(DoubleNum sal) {
		this.min = sal.min();
		this.max = sal.max();
	}

	/**
	 * 經測試，當屬性成員有被標註， 到資料庫做請求交易前都還是會過．最後才會開始做驗證，但如一開始就有加@Valid，則一開始就會做
	 */
	@Override
	public boolean isValid(Double value, ConstraintValidatorContext arg1) {
		if (value == null) {
			return false;
		}
		if (max >= value && min <= value) {
			return true;
		}
		return false;
	}

}
