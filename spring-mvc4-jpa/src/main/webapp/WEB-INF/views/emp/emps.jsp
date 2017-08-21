<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%
	String contextPath = request.getContextPath();
%>
<html>
<head>
<link href='<%=contextPath + "/resources/css/bootstrap.min.css"%>' rel="stylesheet">
<link href='<%=contextPath + "/resources/css/font-awesome.min.css"%>' rel="stylesheet">
<link href='<%=contextPath + "/resources/css/emp.css"%>' rel="stylesheet">
<script src="<%=contextPath + "/resources/js/jquery-3.2.1.min.js"%>"></script>
<script src="<%=contextPath + "/resources/js/bootstrap.min.js"%>"></script>
</head>
<body>
    <!-- 頁面第一排 -->
	<div class="navbar navbar-inverse navbar-fixed-left">
		<div class="container-fluid">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
					<span class="icon-bar"></span> <span class="icon-bar"></span> <span class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="#####">iii</a>
			</div>
			<div class="collapse navbar-collapse" id="myNavbar">
				<ul class="nav navbar-nav">
					<li><a href="<%=contextPath%>/">回首頁</a></li>
					<li><a>待完工</a></li>
					<li><a>待完工</a></li>
					<li><a>待完工</a></li>
				</ul>
				<ul class="nav navbar-nav navbar-right">
					<li><a href="#"><span class="glyphicon glyphicon-user"></span>註冊</a></li>
					<li><a href="#"><span class="glyphicon glyphicon-log-in"></span>登入</a></li>
				</ul>
			</div>
		</div>
	</div>
	<!-- 頁面本體 -->
	<div class="container-fluid">
		<div class="row">

			<div class="col-md-12">
				<div class="table-responsive">

					<table id="mytable" class="table table-bordered" style="margin: 10px; width: 60%;">
						<thead>
							<tr>
								<th>員工編號</th>
								<th>員工姓名</th>
								<th>職稱</th>
								<th>雇用日期</th>
								<th>薪水</th>
								<th>業務獎金</th>
								<th>部門</th>
								<th><a class="btn btn-default" href="<%=contextPath%>/addView">新增員工</a></th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="emp" items="${emps}">
								<tr>
									<td>${emp.empno}</td>
									<td>${emp.ename}</td>
									<td>${emp.job}</td>
									<td>${emp.hiredate}</td>
									<td>${emp.sal}</td>
									<td>${emp.comm}</td>
									<td>${emp.deptVO.dname}</td>
									<td>
									    <a class="btn btn-primary" href="<%=contextPath%>/employee/editEmpView/${emp.empno}">編輯</a>
										<form action="<%=contextPath%>/employee/deleteEmp" method='post'>
											<input type='hidden' name='empno' value='${emp.empno}'>
											<button class="btn btn-warning" type='submit'>刪除</button>
										</form>
									</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
					<div class="clearfix"></div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>