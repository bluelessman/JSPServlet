<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    boolean i = (session.getAttribute("member") == null)?true:false;
    	%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>mission7</title>
</head>
<body>
	<h2>데이터 입력</h2>
	<form action=<%=i?"LoginForm.jsp":"InsertBoardProcess.jsp"%> method="post">
	title : <input type="text" name="title"/><br/>
	content : <input type="text" name="content"/><br/> 
	id : <input type="text" name="bId"/><br/> 
	<input type="submit" value="데이터 입력"/>
	</form>
	
	<% if(i){
	%>
	<form action="LoginForm.jsp" method="post">
	<input type="submit" value="로그인"/>
	</form>
		<%}else{ %>
	<form action="Logout.jsp" method="post">
	<input type="submit" value="로그아웃"/>
	</form>
	<%} %>
</body>
</html>