<%@ include file="header.jsp"%>

<div class="container-fluid">
	<div class="row">

		<div class="col-md-12">
			<div class="table-responsive">

				<table id="mytable" class="table table-bordered"
					style="margin: 10px; width: 60%;">
					<thead>
						<th>empno</th>
						<th>ename</th>
						<th>job</th>
						<th>hiredate</th>
						<th>sal</th>
						<th>comm</th>
						<th>deptno</th>
					</thead>
					<tbody>
						<form action="<%=request.getContextPath()%>/emp/updateEmpsDeptno"
							method="post">
							<c:forEach var="emp" items="${emps}">
								<tr>
									<td>${emp.empno}</td>
									<td>${emp.ename}</td>
									<td>${emp.job}</td>
									<td>${emp.hiredate}</td>
									<td>${emp.sal}</td>
									<td>${emp.comm}</td>
									<td>${emp.deptVO.deptno}</td>
									<td><input type="checkbox" name="emps" value="${emp}"/>
									</td>
								</tr>
							</c:forEach>
							<div>
								<select name="deptno">
									<option value="10">10</option>
									<option value="20">20</option>
									<option value="30">30</option>
									<option value="40">40</option>
								</select>
								<button type="submit">change</button>
							</div>
						</form>
					</tbody>
				</table>
				<div class="clearfix"></div>
			</div>
		</div>
	</div>
</div>

<%@ include file="footer.jsp"%>