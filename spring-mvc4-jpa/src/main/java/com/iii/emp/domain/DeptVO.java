package com.iii.emp.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

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

	@Override
	public String toString() {
		return "[deptno:" + deptno + ", dname:" + dname + ", loc:" + loc;
	}

}
