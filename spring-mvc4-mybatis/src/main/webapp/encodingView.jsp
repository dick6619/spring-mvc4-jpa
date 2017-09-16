<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	String contextPath = request.getContextPath();
    String reqEncoding = request.getCharacterEncoding();
    String resEncoding = response.getCharacterEncoding();
%>
<html>
<head>
<link href='<%=contextPath + "/resources/css/bootstrap.min.css"%>' rel="stylesheet">
<link href='<%=contextPath + "/resources/css/font-awesome.min.css"%>' rel="stylesheet">
<link href='<%=contextPath + "/resources/css/emp.css"%>' rel="stylesheet">
<script src="<%=contextPath + "/resources/js/jquery-3.2.1.min.js"%>"></script>
<script src="<%=contextPath + "/resources/js/bootstrap.min.js"%>"></script>
<script>
    //
    function test1() {
    	    alert('[tell browser] use= ' + '<%=resEncoding%>' + ' encoding');
    }
    function test2() {
	    alert('[tell Sever] use= ' + '<%=reqEncoding%>' + ' encoding');
}
</script>
</head>
<body>
<h4>@jsp: charset = UTF-8:</h4> <font color="blue">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;下指令給瀏覽器，用UTF-8解碼．</font>
<h4>@jsp: pageEncoding = UTF-8:</h4> <font color="blue">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;下指令給server，用UTF-8解碼．等於resquest.setCharacterEncoding("UTF-8")</font>
<h4>@jsp: Template Data:</h4> <font color="blue">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;HTML的部分container不會處理，charset沒設定編碼預設用西歐語系</font>
<h4>@jsp: Elements:</h4> <font color="blue">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;java code的部分container會處理，會被撰寫的程式碼處理</font>
<h4>@back: filter config:</h4> <font color="blue">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;spring filter</font>
<h4>@back: server get uri config:</h4> <font color="blue">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;tomcat8 default utf-8</font>
<h4>@back: datebase encode config:</h4> <font color="blue">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;?characterEncoding=utf-8</font>

<br><br>
<button onclick='test1()'>charset</button>
<button onclick='test2()'>pageEncoding</button>
</body>
</html>