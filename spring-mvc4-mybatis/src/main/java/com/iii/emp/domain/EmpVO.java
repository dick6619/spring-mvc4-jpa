package com.iii.emp.domain;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class EmpVO {

	public EmpVO() {
	}

	private Integer empno;
	private String ename;
	private String job;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd hh:mm:ss")
	private Date hiredate;
	private Double sal;
	private Double comm;
	private Integer deptno;

	public Integer getEmpno() {
		return empno;
	}

	public void setEmpno(Integer empno) {
		this.empno = empno;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public Date getHiredate() {
		return hiredate;
	}

	public void setHiredate(Date hiredate) {
		this.hiredate = hiredate;
	}

	public Double getSal() {
		return sal;
	}

	public void setSal(Double sal) {
		this.sal = sal;
	}

	public Double getComm() {
		return comm;
	}

	public void setComm(Double comm) {
		this.comm = comm;
	}

	public Integer getDeptno() {
		return deptno;
	}

	public void setDeptno(Integer deptno) {
		this.deptno = deptno;
	}

	@Override
	public String toString() {
		return "[empno:" + empno + ", ename:" + ename + ", job:" + job + ", hiredate:" + hiredate + ", sal:" + sal
				+ ", comm:" + comm + ", deptno:" + deptno;
	}

}