<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insertfail</title>
</head>
<body>
<h2>입력 실패</h2>
<h4><%=request.getParameter("msg")%></h4>
<form action="InsertForm.jsp" method="post">
<input type="submit" value="돌아가기"/>
</form>
</body>
</html>