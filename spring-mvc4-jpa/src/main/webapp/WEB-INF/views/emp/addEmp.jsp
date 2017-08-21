<%@ include file="/WEB-INF/views/header.jsp"%>
<%@ page contentType="text/html; charset=UTF-8" %>
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