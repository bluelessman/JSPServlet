<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>지폐 계산</title>
</head>
<body>
<h2>지폐 계산</h2>
<form  action="moneyMain.jsp" method="post">
금액을 입력하세요 : <input type="number" name="n"/><br/>
<input type="submit" value="계산"/>
</form>
<%
if(request.getParameter("n_50")!=null){
	%>
	<p>5만원권 : <%= request.getParameter("n_50")%>장</p>
	<p>1만원권 : <%= request.getParameter("n_10")%>장</p>
	<p>5천원권 : <%= request.getParameter("n_5")%>장</p>
	<p>1천원권 : <%= request.getParameter("n_1")%>장</p>
<%
}
%>
</body>
</html>