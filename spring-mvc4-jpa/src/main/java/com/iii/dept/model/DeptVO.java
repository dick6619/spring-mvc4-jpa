package com.iii.dept.model;

import java.lang.reflect.Field;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;

import org.json.JSONObject;

import com.iii.emp.model.EmpVO;

@Entity
@Table(name = "dept2")
public class DeptVO {

	public DeptVO() {
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer deptno;
	private String dname;
	private String loc;
	/*
	 * lazy = true 延遲初始，只有在物件真正需要資料時，才會從資料庫載入資料 lazy = false
	 * 延遲初始關閉，除了屬性資料被載入外，連有關係的多方資料頁會一併被載入(效能問題) mappedBy
	 * 預設都為false．指的是不要用此指定的物件作為主控方．
	 */
	// @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy =
	// "deptVO")
	
	// Gson -> org.hibernate.LazyInitializationException ???先註解
	// @OneToMany(cascade = CascadeType.ALL, mappedBy = "deptVO")
	// @OrderBy("empno asc")
	// private Set<EmpVO> emps = new HashSet<EmpVO>();

	public Integer getDeptno() {
		return deptno;
	}

	public void setDeptno(Integer deptno) {
		this.deptno = deptno;
	}

	public String getDname() {
		return dname;
	}

	public void setDname(String dname) {
		this.dname = dname;
	}

	public String getLoc() {
		return loc;
	}

	public void setLoc(String loc) {
		this.loc = loc;
	}

	// public Set<EmpVO> getEmps() {
	// return emps;
	// }
	//
	// public void setEmps(Set<EmpVO> emps) {
	// this.emps = emps;
	// }

	/**
	 * 將VO轉為JSON
	 */
	public JSONObject toJSON() throws Exception {
		//
		JSONObject json = new JSONObject();
		for (Field field : DeptVO.class.getDeclaredFields()) {
			json.put(field.getName(), field.get(this));
		}
		return json;
	}

}
