<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%-- <%@ page language="java" contentType="text/html; charset=Big5" pageEncoding="Big5"%> --%>
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
    	    alert('Server Response use '  + '<%=resEncoding%>' + ' and [tell client browser] use= ' + '<%=resEncoding%>' + ' encoding');
    }
    function test2() {
	    alert('Client Request use '  + '<%=reqEncoding%>' + ' and [tell Sever] use= ' + '<%=reqEncoding%>' + ' encoding');
}
</script>
</head>
<body>
<h4>charset = UTF-8:</h4> <p>下指令給瀏覽器，用UTF-8解碼．在server response.setCharacterEncoding("UTF-8")的狀況下
<h4>pageEncoding = UTF-8:</h4> <p>下指令給server，用UTF-8解碼．等於resquest.setCharacterEncoding("UTF-8")
<h4>Template Data:</h4> <p>HTML的部分container不會處理，直接送到client端，charset沒設定編碼預設是用西歐語系解碼
<h4>Elements:</h4> <p>java code的部分container會處理，會使用到編碼濾器<br><br>
<button onclick='test1()'>charset</button>
<button onclick='test2()'>pageEncoding</button>
</body>
</html>