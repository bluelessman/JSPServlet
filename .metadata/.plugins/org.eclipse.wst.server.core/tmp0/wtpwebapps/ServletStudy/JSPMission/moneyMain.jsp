<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>머니메인</title>
</head>
<body>
<%
int n = Integer.parseInt(request.getParameter("n"));
int n_50 = n/50000;
n %= 50000;
int n_10 = n/10000;
n %= 10000;
int n_5 = n/5000;
n %= 5000;
int n_1 = n/1000;
response.sendRedirect("money.jsp?n_50="+n_50+"&n_10="+n_10+"&n_5="+n_5+"&n_1="+n_1);

%>
</body>
</html>