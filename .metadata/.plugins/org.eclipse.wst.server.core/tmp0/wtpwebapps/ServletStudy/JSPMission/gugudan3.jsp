<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>구구단3</title>
</head>
<body>
<h2>구구단3</h2>
<form method="post" action="gugudanMain.jsp">
<input type="radio" name="type" value="dan" checked="checked"/>dan<br/>
<input type="radio" name="type" value="col"/>col<br/>
<input type="number" name="num" value=""/>단수/열수<br/>
<input type="submit" value="gugu"/>
</form>
</body>
</html>