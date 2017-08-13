<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="Big5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String contextPath = request.getContextPath();
%>
<html>
<head>
<link href='<%=contextPath + "/resources/css/bootstrap.min.css"%>'
	rel="stylesheet">
<link href='<%=contextPath + "/resources/css/font-awesome.min.css"%>'
	rel="stylesheet">
<link href='<%=contextPath + "/resources/css/emp.css"%>'
	rel="stylesheet">
<script
	src="<%=request.getContextPath() + "/resources/js/jquery-3.2.1.min.js"%>"></script>
<script
	src="<%=request.getContextPath() + "/resources/js/bootstrap.min.js"%>"></script>

<script>
	function test1() {
		alert("111");
	}
	function test2() {
		$.ajax({
			url : 'http://localhost:8080/spring-mvc4-jpa/rest/json2',
			type : 'GET',
			dataType : 'json',
			success : function(data) {
				// 				for (var i = 0; i < data.length; i++) {
				// 					alert(data[i].ename);
				// 				}
				$.each(data, function() {
					alert(this.ename);
				});
				// 				$.each(data, function(i) {
				// 					alert(data[i].ename);
				// 				});
			},
			error : function() {
				alert('ERROR!!!');
			}
		});
	}
</script>
</head>
<body>
	<button onclick='test1()'>alert</button>
	<button onclick='test2()'>ajax</button>
</body>
</html>