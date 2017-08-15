package com.iii.dept.model;

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

import com.iii.emp.model.EmpVO;

@Entity
@Table(name = "dept2")
public class DeptVOErrorCase {

	public DeptVOErrorCase() {
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer deptno;
	private String dname;
	private String loc;
	
	/*
	 * LAZY: 初始延遲屬性
	 *       1. 一對多的關係要小心效能問題，如找一個部門結果連同底下幾千個員工都一併查．
	 *       2. 一對多的關係內預設為fetch = FetchType.LAZY
	 * mappedBy: 非主控方
	 *       1. 預設都為false，不要用此指定的物件作為主控方．
	 * 以下設定導致gson, jackson進行bean轉換時噴錯．
	 */
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "deptVO")
	@OrderBy("empno asc")
	private Set<EmpVO> emps = new HashSet<EmpVO>();

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

	public Set<EmpVO> getEmps() {
		return emps;
	}

	public void setEmps(Set<EmpVO> emps) {
		this.emps = emps;
	}

}
