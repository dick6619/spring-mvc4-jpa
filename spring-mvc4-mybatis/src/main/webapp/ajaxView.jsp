<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String contextPath = request.getContextPath();
    String pageEncoding = request.getCharacterEncoding();
    String charset = response.getCharacterEncoding();
%>
<html>
<head>
<link href='<%=contextPath + "/resources/css/bootstrap.min.css"%>' rel="stylesheet">
<link href='<%=contextPath + "/resources/css/font-awesome.min.css"%>' rel="stylesheet">
<link href='<%=contextPath + "/resources/css/emp.css"%>' rel="stylesheet">
<script src="<%=contextPath + "/resources/js/jquery-3.2.1.min.js"%>"></script>
<script src="<%=contextPath + "/resources/js/bootstrap.min.js"%>"></script>
<script>
	// 	test restful ws use ajax get
	function iiiEmps() {
		$.ajax({
			url : 'restWS2/getEmps',
			type : 'GET',
			dataType : 'json',
			cache : false,
			success : function(data) {
				$('#body').empty();
				for (var i = 0; i < data.length; i++) {
					$('#body').append('<tr>' +
			                   '<td>' + data[i].empno + '</td>' + 
			                   '<td>' + data[i].ename + '</td>' + 
			                   '<td>' + data[i].job + '</td>' + 
			                   '<td>' + data[i].hiredate + '</td>' + 
			                   '<td>' + data[i].sal + '</td>' + 
			                   '<td>' + data[i].comm + '</td>' + 
			                   '<td>' + data[i].deptVO.dname + '</td>' + 
			                   '</tr>')
				}
				// 				$.each(data, function() {
				// 					alert(this.empno + ',' + this.ename);
				// 				});
				// 				$.each(data, function(i) {
				// 					alert(data[i].ename);
				// 				});
			},
			error : function(data) {
				alert('error!!!');
// 				$('#error').append(data.responseText);
			}
		});
	}
	function iiiEmp() {
		$.get({
			url : 'restWS2/getEmp/' + $('#empno').val(),
			dataType : 'json',
			cache : false,
			success : function(data) {
				$('#body').empty();
				$('#body').append('<tr>' +
				                   '<td>' + data.empno + '</td>' + 
				                   '<td>' + data.ename + '</td>' + 
				                   '<td>' + data.job + '</td>' + 
				                   '<td>' + data.hiredate + '</td>' + 
				                   '<td>' + data.sal + '</td>' + 
				                   '<td>' + data.comm + '</td>' + 
				                   '<td>' + data.deptVO.dname + '</td>' + 
				                   '</tr>')
			},
			error : function(data) {
				alert('error!!!');
// 				$('#error').append(data.responseText);
			}
		});
	}
	function iiiEmpLike() {
		$.get({
			url : 'restWS2/getLikeEmp/' + $('#ename').val(),
			dataType : 'json',
			cache : false,
			success : function(data) {
				$('#body').empty();
				for (var i = 0; i < data.length; i++) {
					$('#body').append('<tr>' +
			                   '<td>' + data[i].empno + '</td>' + 
			                   '<td>' + data[i].ename + '</td>' + 
			                   '<td>' + data[i].job + '</td>' + 
			                   '<td>' + data[i].hiredate + '</td>' + 
			                   '<td>' + data[i].sal + '</td>' + 
			                   '<td>' + data[i].comm + '</td>' + 
			                   '<td>' + data[i].deptVO.dname + '</td>' + 
			                   '</tr>')
				}
			},
			error : function(data) {
				alert('error!!!');
// 				$('#error').append(data.responseText);
			}
		});
	}
	function addEmp() {
		$.post({
			url : '',
			data : '',
			success : function(data) {
				alert('add ok!!!');
			},
			error : function(data) {
				alert('add error!!!');
			}
		});
	}
	function updateEmp() {
		$.put({
			url : '',
			data : '',
			success : function(data) {
				alert('update ok!!!');
			},
			error : function(data) {
				alert('update error!!!');
			}
		});
	}
	function deleteEmp() {
		$.ajax({
			type : 'delete',
			url : '',
			data : '',
			success : function(data) {
				alert('delete ok!!!');
			},
			error : function(data) {
				alert('delete error!!!');
			}
		});
	}
</script>
</head>
<body>
	<input type='text' id='empno'>
	<button onclick='iiiEmp()'>指定員工編號搜尋</button>
	<input type='text' id='ename'>
	<button onclick='iiiEmpLike()'>姓名模糊搜尋</button>
	<button onclick='iiiEmps()'>所有員工</button>

    <p id='error'>
	<table class='table table-bordered' style='margin: 10px; width: 60%;'>
		<thead>
			<tr>
				<th>員工編號</th>
				<th>員工姓名</th>
				<th>職稱</th>
				<th>任職日期</th>
				<th>薪水</th>
				<th>獎金</th>
				<th>部門</th>
			</tr>
		</thead>
		<tbody id='body'>
        </tbody>
	</table>
</body>
</html>