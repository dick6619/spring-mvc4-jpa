package com.iii.emp.model;

import java.lang.reflect.Field;
import java.util.LinkedHashMap;
import java.util.Map;

import com.iii.utils.BeanUtil;

public class HelloBean {

	private String name;
	private Integer number;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	/**
	 * 無法共用，因屬性成員修飾詞為private
	 * */
	public Map<String, Object> toMap() throws Exception {
		//
		Map<String, Object> map = new LinkedHashMap<>();
		for (Field field : this.getClass().getDeclaredFields()) {
			map.put(field.getName(), field.get(this));
		}
		return map;
	}
	
	public static void main(String[] args) throws Exception {
		HelloBean hello = new HelloBean();
		hello.setName("PETER");
		hello.setNumber(1607023);
		// HelloBean toMap() test
		System.out.println("hello.toMap -> " + hello.toMap());
		// BeanUtil toMap() test
		System.out.println("BeanUtil.toMap -> " + BeanUtil.toMap(hello));
	}

}
