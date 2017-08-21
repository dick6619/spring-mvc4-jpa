package com.iii.framework.core.exception;

import com.iii.framework.core.enumeration.IIIError;

public class IIIException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	// enumeration
	private IIIError error;
	private Object detail;

	public IIIException(IIIError error) {
		super(getErrorMsg(error));
		this.error = error;
	}

	public IIIException(IIIError error, Throwable throwable) {
		super(getErrorMsg(error), throwable);
		this.error = error;
	}

	public IIIException(IIIError error, Object detail) {
		super(getErrorMsg(error));
		this.error = error;
		this.detail = detail;
	}

	// get enumeration error can be additional handle
	public IIIError getError() {
		return this.error;
	}

	public Object getDetail() {
		return this.detail;
	}

	// error message
	private static String getErrorMsg(IIIError error) {

		if (error == null) {
			return "IIIError is null";
		}
		return "[" + error.getSystem().name() + "]" + 
		       "[" + error.getCode() + "]" + 
		       "[" + error.getMessage() + "]";
	}

}
