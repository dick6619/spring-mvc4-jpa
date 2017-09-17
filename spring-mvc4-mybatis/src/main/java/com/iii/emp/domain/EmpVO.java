package com.iii.emp.domain;

import java.io.Serializable;
import java.sql.Date;

public class EmpVO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	public EmpVO() {
	}

	private Integer empno;
	private String ename;
	private String job;
	private Date hiredate;
	private Double sal;
	private Double comm;
//	private Integer deptno;
	private DeptVO deptVO;

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
//
//	public Integer getDeptno() {
//		return deptno;
//	}
//
//	public void setDeptno(Integer deptno) {
//		this.deptno = deptno;
//	}
	
	public DeptVO getDeptVO() {
		return deptVO;
	}

	public void setDeptVO(DeptVO deptVO) {
		this.deptVO = deptVO;
	}

	@Override
	public String toString() {
		return "[empno:" + empno + ", ename:" + ename + ", job:" + job + ", hiredate:" + hiredate + ", sal:" + sal
				+ ", comm:" + comm + ", deptno:" + (deptVO == null ? "isNull" : deptVO.getDeptno());
	}

}