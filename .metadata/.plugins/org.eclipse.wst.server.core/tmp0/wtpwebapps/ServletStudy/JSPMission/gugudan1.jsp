<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>구구단1</title>
</head>
<body>
	<h2>구구단1</h2>
	<%
	int n;
	if (request.getParameter("dan") == null)
		n = 2;
	else
		n = Integer.parseInt(request.getParameter("dan"));
// 	for (int i = 1; i <= 9; i++) {
// 		out.println(n + " * " + i + " = " + (n * i) + "</br>");
// 	}
	for (int i = 1; i <= 9; i++) {
	%>
	<p><%=n%>
		*
		<%=i%>
		=
		<%=n * i%></p>
	<%
	}
	%>
</body>
</html>