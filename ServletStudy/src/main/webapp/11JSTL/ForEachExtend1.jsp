<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>foreach2</title>
</head>
<body>
<h4>향상된 for</h4>
<%
String[] rgba = {"Red","Green","Blue","Black"};
%>
<c:forEach items="<%=rgba %>" var="c">
<span style="color:${c};">${c }</span>
</c:forEach>

<h4>속성 살펴보기</h4>
<table border="1">
<c:forEach items="<%=rgba %>" var="c" varStatus="loop">
<tr>
<td>count : ${loop.count }</td>
<td>index : ${loop.index }</td>
<td>current : ${loop.current }</td>
<td>first : ${loop.first }</td>
<td>last : ${loop.last }</td>
</tr>
</c:forEach>
</table>
</body>
</html>