package com.iii.framework.enumeration;

import com.iii.emp.enumeration.EmpError;
import com.iii.framework.exception.ServiceException;

public class Test {

	public static void main(String[] args) {
		
		System.out.println(new ServiceException(EmpError.EMPTY_DATA));
	}

}
