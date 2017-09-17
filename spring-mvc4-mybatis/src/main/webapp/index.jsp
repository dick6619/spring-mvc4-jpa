<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String contextPath = request.getContextPath();
%>
<html>
<body>
	<h1>Hello World! III Employee</h1>
	<ol>
		<li><a href="<%=contextPath%>/employee/emps">Spring MVC - JPA(Hibernate) CRUD</a></li>
		<li><a href="<%=contextPath%>/ajaxView.jsp">AJAX call RestfulWS</a></li>
		<li><a href="<%=contextPath%>/restWS2/getEmps">RestfulWS use default Jackson converter since Spring3.2</a></li>
		<li><a href="<%=contextPath%>/soap">soap-XML use Apache CXF</a></li>
<%-- 		<li><a href="<%=contextPath%>/encodingView.jsp">Encodig view</a></li> --%>
		<li><a href="<%=contextPath%>/includeVies.jsp">JSP include view</a></li>
	</ol>
</body>
</html>