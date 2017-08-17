package com.iii.framework.enumeration;

public interface IIIError {
	// error code
	String getCode();
    // iii system
	IIISystem getSystem();
    // error message
	String getMessage();

}
