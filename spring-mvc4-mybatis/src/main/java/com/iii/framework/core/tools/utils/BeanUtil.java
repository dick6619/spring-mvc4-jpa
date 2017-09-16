package com.iii.framework.core.tools.utils;

import java.lang.reflect.Method;
import java.util.LinkedHashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

public class BeanUtil {

	/**
	 * 將 java bean 轉為 LinkedHashMap
	 * @param bean
	 * */
	public static <T> Map<String, Object> toMap(T bean) throws Exception {
		//
		Map<String, Object> map = new LinkedHashMap<>();
		// get class all function
		for (Method method : bean.getClass().getDeclaredMethods()) {
			String methodName = method.getName();
			// java bean rule
			if (StringUtils.startsWith(methodName, "get")) {
				// put key, and get function value
				map.put(methodName.substring(3).toLowerCase(), method.invoke(bean, new Object[] {}));
			}
		}
		return map;
	}
	// Object[] parameter = {new Integer(90), new String("123")}; 調用方法帶入參數
}
