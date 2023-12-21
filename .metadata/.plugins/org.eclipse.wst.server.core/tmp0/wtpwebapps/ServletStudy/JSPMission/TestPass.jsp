<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>삼항연산자</title>
</head>
<body>
<h2>삼항 연산자</h2>
<form method="post" action="./TestPass.do">
국어 : <input type="text" name="guk"/><br/>
영어 : <input type="text" name="eng"/><br/>
수학 : <input type="text" name="math"/><br/>
<input type="submit" value="제출"/>
</form>
<p>
<strong>${message}</strong>
<br/>
</p>
</body>
</html>