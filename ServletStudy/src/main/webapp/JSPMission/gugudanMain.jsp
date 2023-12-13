<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>구구단메인</title>
</head>
<body>
<%
String type = request.getParameter("type");
String num = request.getParameter("num");
if(type.equals("dan")){
	response.sendRedirect("gugudan1.jsp?dan="+num);
}else{
	response.sendRedirect("gugudan2.jsp?col="+num);
}

%>
</body>
</html>