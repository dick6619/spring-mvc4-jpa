<%@ include file="/WEB-INF/views/header.jsp"%>
<%@ page contentType="text/html; charset=UTF-8" %>
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
							<th><a class="btn btn-default"
								href="<%=contextPath%>/addView">新增員工</a></th>
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

<%@ include file="/WEB-INF/views/footer.jsp"%>