package com.iii.framework.core.exception;

import com.iii.framework.core.enumeration.IIIError;

public class ServiceException extends IIIException {

	private static final long serialVersionUID = 1L;

	public ServiceException(IIIError error) {
		super(error);
	}

	public ServiceException(IIIError error, Throwable cause) {
		super(error, cause);
	}

	public ServiceException(IIIError error, Object detail) {
		super(error, detail);
	}

}
