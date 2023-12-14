<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>InsertSuccess</title>
</head>
<body>
<h2>입력 성공</h2>
<h4><%=request.getParameter("result")%>행이 입력되었습니다.</h4>
<form action="InsertBoardForm.jsp" method="post">
<input type="submit" value="돌아가기"/>
</form>
</body>
</html>