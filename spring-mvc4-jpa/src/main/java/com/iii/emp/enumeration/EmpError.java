package com.iii.emp.enumeration;

import com.iii.framework.enumeration.IIIError;
import com.iii.framework.enumeration.IIISystem;
/**
 * 
 * */
public enum EmpError implements IIIError{
	PARAM_ERROR("10001", IIISystem.EMP, "參數錯誤"),
	EMPTY_DATA("10001", IIISystem.EMP, "查無資料"),
	UNDEFINED("99999", IIISystem.EMP, "未經定義的錯誤");
	
	//
	private EmpError(String code, IIISystem system, String message) {
		this.code = code;
		this.system = system;
		this.message = message;
	}
	
	private String code;
	private IIISystem system;
	private String message;
	

	@Override
	public String getCode() {
		return this.code;
	}

	@Override
	public IIISystem getSystem() {
		return this.system;
	}

	@Override
	public String getMessage() {
		return this.message;
	}

}