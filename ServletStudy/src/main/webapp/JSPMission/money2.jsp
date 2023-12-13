<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>지폐 계산2</title>
</head>
<body>
<h2>지폐 계산2</h2>
<form>
금액을 입력하세요 : <input type="number" name="n"/><br/>
<input type="submit" value="계산"/>
</form>
<%
if(request.getParameter("n")!=null){
	int n = Integer.parseInt(request.getParameter("n"));
	int n_50 = n/50000;
	n %= 50000;
	int n_10 = n/10000;
	n %= 10000;
	int n_5 = n/5000;
	n %= 5000;
	int n_1 = n/1000;
	%>
	<p>5만원권 : <%= n_50%>장</p>
	<p>1만원권 : <%= n_10%>장</p>
	<p>5천원권 : <%= n_5%>장</p>
	<p>1천원권 : <%= n_1%>장</p>
<%
}
%>
</body>
</html>