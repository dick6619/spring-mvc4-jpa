package com.iii.framework.exception;

import com.iii.framework.enumeration.IIIError;

public class IIIException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	//
	private IIIError error;

	public IIIException(IIIError error) {
		super(getErrorMsg(error));
		this.error = error;
	}
	
	public IIIException(IIIError error, Throwable throwable) {
		super(getErrorMsg(error), throwable);
		this.error = error;
	}

	// 錯誤的比對
	public IIIError getError() {
		return this.error;
	}
	
	// 錯誤的訊息
	private static String getErrorMsg (IIIError error) {
		
		if(error == null) {
			return "IIIError is null";
		}
		return "[" + error.getSystem().name() + "]" + 
		       "[" + error.getCode() + "]" + 
		       "[" + error.getMessage() + "]";
	}

}
