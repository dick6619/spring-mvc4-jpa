package com.iii.dept.vo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "dept2")
public class DeptVO {
    // 
	public DeptVO() {
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer deptno;
	private String dname;
	private String loc;
	/*
	 * 註1:【現在是設定成 cascade="all" lazy="false" inverse="true"之意】
	 * 註2:【mappedBy="多方的關聯屬性名"：用在雙向關聯中，把關係的控制權反轉】【deptVO是EmpVO的屬性】
	 * 註3:【原預設為@OneToMany(fetch=FetchType.LAZY, mappedBy="deptVO")之意】 -->
	 * 【是指原為lazy="true" inverse="true"之意】 FetchType.EAGER : Defines that data
	 * must be eagerly fetched FetchType.LAZY : Defines that data can be lazily
	 * fetched
	 */
	// @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy =
	// "deptVO")
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

}
