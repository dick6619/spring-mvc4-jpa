<%@ include file="/WEB-INF/views/header.jsp"%>
<!-- include header編碼吃不到 -->
<%@ page contentType="text/html; charset=UTF-8" %>
<div class="container-fluid">

	<div class="row">
		<!-- 左邊空格 -->
		<div class="col-md-1"></div>
		<div class="col-md-10">
			<h2>Add Emp</h2>
			<form class="form-horizontal"
				action="<%=request.getContextPath()%>/employee/addEmp" method="post"
				role="form">
				<div class="form-group">
					<label for="title">Ename</label>
					<div class="input-group">
						<span class="input-group-addon"> <span
							class="glyphicon glyphicon-cog"></span></span> <input type="text"
							class="form-control" name="ename" id="ename"
							placeholder="Enter Ename" required>
					</div>
				</div>
				<div class="form-group">
					<label for="desc">Job</label>
					<div class="input-group">
						<span class="input-group-addon"> <span
							class="glyphicon glyphicon-pencil"></span></span> <input type="text"
							class="form-control" name="job" placeholder="Enter Job" required>
					</div>
				</div>
				<div class="form-group">
					<label for="desc">Hiredate</label>
					<div class="input-group">
						<span class="input-group-addon"> <span
							class="glyphicon glyphicon-pencil"></span></span> <input type="text"
							class="form-control" name="hiredate" placeholder="Enter Hiredate"
							required>
					</div>
				</div>
				<div class="form-group">
					<label for="desc">Sal</label>
					<div class="input-group">
						<span class="input-group-addon"> <span
							class="glyphicon glyphicon-pencil"></span></span> <input type="text"
							class="form-control" name="sal" placeholder="Enter Sal" required>
					</div>
				</div>
				<div class="form-group">
					<label for="desc">Comm</label>
					<div class="input-group">
						<span class="input-group-addon"> <span
							class="glyphicon glyphicon-pencil"></span></span> <input type="text"
							class="form-control" name="comm" placeholder="Enter Comm"
							required>
					</div>
				</div>
				<div class="form-group">
					<label for="desc">Deptno</label>
					<div class="input-group">
						<span class="input-group-addon"><span class="glyphicon glyphicon-pencil"></span></span>
						<select
							class="form-control" name="deptno">
							<option value="10">財務部</option>
							<option value="20">業務部</option>
							<option value="30">研發部</option>
							<option value="40">生管部</option>
						</select>
					</div>
				</div>

				<button type="submit" class="btn btn-primary">Submit</button>
			</form>

		</div>
		<!-- 右邊空格 -->
		<div class="col-md-1"></div>
	</div>
</div>