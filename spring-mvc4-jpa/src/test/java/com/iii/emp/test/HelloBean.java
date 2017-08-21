package com.iii.emp.test;

import java.lang.reflect.Field;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.iii.framework.core.tools.utils.BeanUtil;
import com.iii.framework.core.validation.DateDiff;

@DateDiff(start = "strartDate", end = "endDate", diff = "<1Y")
public class HelloBean {

	@Pattern(regexp = "[a-zA-Z]*")
	private String name;
	@Size(min = 1000, max = 10000)
	private Integer number;
	@Pattern(regexp = "([a-zA-Z])([0-9])(-)([0-9]){4}|([0-9]){3}(-)([0-9]){3}|([a-zA-Z]){2}(-)([0-9]){4}")
	private String plateNo;
	private Date strartDate;
	private Date endDate;

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

	public String getPlateNo() {
		return plateNo;
	}

	public void setPlateNo(String plateNo) {
		this.plateNo = plateNo;
	}

	public Date getStrartDate() {
		return strartDate;
	}

	public void setStrartDate(Date strartDate) {
		this.strartDate = strartDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	/**
	 * 無法共用，因屬性成員修飾詞為private
	 */
	public Map<String, Object> toMap() throws Exception {
		//
		Map<String, Object> map = new LinkedHashMap<>();
		for (Field field : this.getClass().getDeclaredFields()) {
			map.put(field.getName(), field.get(this));
		}
		return map;
	}

	/**
	 * 測試
	 */
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
