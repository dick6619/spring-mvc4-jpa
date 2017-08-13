<%@ include file="/WEB-INF/views/header.jsp"%>

<div class="container-fluid">
	<div class="row">

		<div class="col-md-12">
			<div class="table-responsive">

				<table id="mytable" class="table table-bordered"
					style="margin: 10px; width: 60%;">
					<thead>
						<tr>
							<th>EMPNO</th>
							<th>ENAME</th>
							<th>JOB</th>
							<th>HIREDATE</th>
							<th>SAL</th>
							<th>COMM</th>
							<th>DEPTNO</th>
							<th><a class="btn btn-default"
								href="<%=contextPath%>/addView">ADD</a></th>
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
								<td>${emp.deptVO.deptno}</td>
								<td><a class="btn btn-primary"
									href="<%=contextPath%>/employee/editEmpView/${emp.empno}">EDIT</a>
									<a class="btn btn-warning"
									href="<%=contextPath%>/employee/deleteEmp/${emp.empno}">DELETE</a></td>
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