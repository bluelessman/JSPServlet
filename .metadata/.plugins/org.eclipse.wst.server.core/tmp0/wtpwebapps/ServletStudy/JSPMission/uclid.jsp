<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>유클리드</title>
</head>
<body>
	<h2>유클리드 호제법</h2>
	<form action="uclidMain.jsp" method="post">
		<input type="number" name="n1" /><br /> <input type="number" name="n2" /><br />
		<input type="submit" value="계산" />
	</form>
	<%
	if (request.getParameter("GCD") != null) {
	%>
	<h2>
		GCD =
		<%=request.getParameter("GCD")%>, LCM =
		<%=request.getParameter("LCM")%></h2>
	<%
	}
	%>

</body>
</html>