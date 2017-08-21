package com.iii.framework.core.enumeration;

public interface IIIError {
	// error code
	String getCode();
    // iii system
	IIISystem getSystem();
    // error message
	String getMessage();

}
