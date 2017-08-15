<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String contextPath = request.getContextPath();
%>
<html>
<body>
	<h1>Hello World! III Employee</h1>
	<ol>
	    <li><a href="<%=contextPath%>/encoding.jsp">encodig note</a></li>
		<li><a href="<%=contextPath%>/employee/emps">Spring MVC - JPA(Hibernate) CRUD</a></li>
		<li><a href="<%=contextPath%>/ajax.jsp">AJAX call WS</a></li>
		<li><a href="<%=contextPath%>/rest/json2">RESTFULWS-JSON use Gson</a></li>
		<li><a href="<%=contextPath%>/rest/json3">RESTFULWS-JSON use Jackson</a></li>
		<li><a href="<%=contextPath%>/soap">soap-XML use Apache CXF</a></li>
	</ol>
</body>
</html>