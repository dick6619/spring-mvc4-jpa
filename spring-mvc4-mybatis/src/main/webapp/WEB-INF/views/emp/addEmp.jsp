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
	<div class="container-fluid">
		<div class="row">
			<!-- 左邊空格 -->
			<div class="col-md-1"></div>
			<div class="col-md-10">
				<h2>新增</h2>
				<form class="form-horizontal" action="<%=request.getContextPath()%>/employee/addEmp" method="post">
					<div class="form-group">
						<label>員工姓名</label>
						<div class="input-group">
							<span class="input-group-addon"> <span class="glyphicon glyphicon-cog"></span></span>
							<input type="text" class="form-control" name="ename" placeholder="Enter Ename" required>
						</div>
					</div>
					<div class="form-group">
						<label>職稱</label>
						<div class="input-group">
							<span class="input-group-addon"> <span class="glyphicon glyphicon-pencil"></span></span>
							<input type="text" class="form-control" name="job" placeholder="Enter Job" required>
						</div>
					</div>
					<div class="form-group">
						<label>雇用日期</label>
						<div class="input-group">
							<span class="input-group-addon"> <span class="glyphicon glyphicon-pencil"></span></span>
							<input type="text" class="form-control" name="hiredate" placeholder="Enter Hiredate" required>
						</div>
					</div>
					<div class="form-group">
						<label>薪水</label>
						<div class="input-group">
							<span class="input-group-addon"> <span class="glyphicon glyphicon-pencil"></span></span>
							<input type="text" class="form-control" name="sal" placeholder="Enter Sal" required>
						</div>
					</div>
					<div class="form-group">
						<label>業務獎金</label>
						<div class="input-group">
							<span class="input-group-addon"> <span class="glyphicon glyphicon-pencil"></span></span>
							<input type="text" class="form-control" name="comm" placeholder="Enter Comm" required>
						</div>
					</div>
					<div class="form-group">
						<label>部門</label>
						<div class="input-group">
							<span class="input-group-addon"> <span class="glyphicon glyphicon-pencil"></span></span>
							<select class="form-control" name="deptno">
								<option value="10">財務部</option>
								<option value="20">研發部</option>
								<option value="30">業務部</option>
								<option value="40">生管部</option>
							</select>
						</div>
					</div>
					<button type="submit" class="btn btn-primary">送出</button>
				</form>
			</div>
			<!-- 右邊空格 -->
			<div class="col-md-1"></div>
		</div>
	</div>
</body>
</html>