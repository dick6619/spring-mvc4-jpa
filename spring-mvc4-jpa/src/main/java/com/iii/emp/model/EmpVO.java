package com.iii.emp.model;

import java.lang.reflect.Field;
import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
//import javax.persistence.Temporal;
//import javax.persistence.TemporalType;

import org.json.JSONObject;

import com.iii.dept.model.DeptVO;

@Entity
@Table(name = "emp2")
public class EmpVO {
	//
	public EmpVO() {
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer empno;
	private String ename;
	private String job;
	private Date hiredate;
	private Date birthday;
	private Double sal;
	private Double comm;

	@ManyToOne
	@JoinColumn(name = "deptno")
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

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
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

	public DeptVO getDeptVO() {
		return deptVO;
	}

	public void setDeptVO(DeptVO deptVO) {
		this.deptVO = deptVO;
	}

	/**
	 * 將VO轉為JSON
	 */
	public JSONObject toJSON() throws Exception {
		//
		JSONObject json = new JSONObject();
		for (Field field : EmpVO.class.getDeclaredFields()) {
			json.put(field.getName(), field.get(this));
		}
		return json;
	}

}

// Method method = EmpVO.class.getMethod("getDeptVO", null); // 取得這方法沒任何的型態,
// Class[] paramType = {Integer.TYPE};
// DeptVO dept = (DeptVO) method.invoke(this, new Object()); // 調用這方法沒任何的參數,
// Object[] param.. = {new Integer(90)};
