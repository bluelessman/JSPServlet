<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>구구단2</title>
</head>
<body>
	<h2>구구단2</h2>
	<table>
		<tr>
			<%
			int col;
			int k = 2;
			int j = 0;
			if (request.getParameter("col") == null)
				col = 3;
			else
				col = Integer.parseInt(request.getParameter("col"));
			for (int i = 2; i < col + 2; i++) {
			%>
			<th scope="col">------<%=i%>단------
			</th>
			<%
			}
			%>
		</tr>
		<%
		while(true){
		for (int i = 1; i <= 9; i++) {
		%>
		<tr>
			<%
			for (j = k; j < col + k && j<10; j++) {
			%>
			<td><%=j%> * <%=i%> = <%=j * i%></td>
			<%
			}
			%>
		</tr>
		<%
		}
		if(j==10) break;
		k = k + col;
		}
		%>
	</table>
	<%--
	int col;
	if (request.getParameter("col") == null)
		col = 3;
	else
		col = Integer.parseInt(request.getParameter("col"));
	out.println("<table><tr>");
	for (int i = 2; i < col + 2; i++) {
		out.println("<th scope=`col`>------" + i + "단------</th>");
	}
	out.println("</tr>");
	for (int i = 1; i <= 9; i++) {
		out.println("<tr>");
		for (int j = 2; j < col + 2; j++) {
			out.println("<td>" + j + " * " + i + " = " + (j * i) + "</td>");
		}
		out.println("</tr>");
	}
	out.println("</table>");
	--%>

</body>
</html>