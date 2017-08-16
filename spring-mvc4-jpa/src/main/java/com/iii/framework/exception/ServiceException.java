package com.iii.framework.exception;

import com.iii.framework.enumeration.IIIError;

public class ServiceException extends IIIException{

	private static final long serialVersionUID = 1L;
	
	public ServiceException(IIIError error) {
		super(error);
	}
	public ServiceException(IIIError error, Throwable cause) {
		super(error, cause);
	}

}
