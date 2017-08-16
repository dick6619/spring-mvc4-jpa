package com.iii.framework.enumeration;

public interface IIIError {
	// 錯誤代碼
	String getCode();
    // 錯誤系統 enum
	IIISystem getSystem();
    // 錯誤訊息
	String getMessage();

}
