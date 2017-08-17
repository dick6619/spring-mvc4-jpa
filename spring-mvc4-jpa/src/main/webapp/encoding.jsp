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
<h4>charset = UTF-8:</h4> <p>�U���O���s�����A��UTF-8�ѽX�D�bserver response.setCharacterEncoding("UTF-8")�����p�U
<h4>pageEncoding = UTF-8:</h4> <p>�U���O��server�A��UTF-8�ѽX�D����resquest.setCharacterEncoding("UTF-8")
<h4>Template Data:</h4> <p>HTML������container���|�B�z�A�����e��client�ݡAcharset�S�]�w�s�X�w�]�O�Φ�ڻy�t�ѽX
<h4>Elements:</h4> <p>java code������container�|�B�z�A�|�ϥΨ�s�X�o��<br><br>
<button onclick='test1()'>charset</button>
<button onclick='test2()'>pageEncoding</button>
</body>
</html>