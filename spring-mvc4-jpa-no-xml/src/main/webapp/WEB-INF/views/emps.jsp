<%@ include file="header.jsp"%>

<div class="container-fluid">
	<div class="row">

		<div class="col-md-12">
			<div class="table-responsive">

				<table id="mytable" class="table table-bordered"
					style="margin: 10px; width: 60%;">
					<thead>
						<tr>
							<th>empno</th>
							<th>ename</th>
							<th>job</th>
							<th>hire date</th>
							<th>sal</th>
							<th>comm</th>
							<th>deptno</th>
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
									href="<%=contextPath%>/emp/editEmpView/${emp.empno}">Edit</a> <a
									class="btn btn-warning"
									href="<%=contextPath%>/emp/deleteEmp/${emp.empno}">Delete</a></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
				<div class="clearfix"></div>
			</div>
		</div>
	</div>
</div>

<%@ include file="footer.jsp"%>