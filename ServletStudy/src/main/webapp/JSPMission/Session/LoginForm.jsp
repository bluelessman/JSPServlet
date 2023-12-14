<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="membership.MemberDTO"%>
<%@page import="membership.MemberDAO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>mission7</title>
</head>
<body>
<h2>로그인이 필요합니다.</h2>
<form>
	아이디 : <input type="text" name="uId"/><br/>
	패스워드 : <input type="password" name="pw"/><br/> 
	<input type="submit" value="로그인하기"/>
	</form>
</body>
</html>
<%
if(request.getParameter("uId")!=null){
String uId = request.getParameter("uId");
String pwd = request.getParameter("pw");

String mysqlDriver = application.getInitParameter("MySQLDriver");
String mysqlURL = application.getInitParameter("MySQLURL");
String mysqlId = application.getInitParameter("MySQLId");
String mysqlPwd = application.getInitParameter("MySQLPwd");

MemberDAO dao = new MemberDAO(mysqlDriver, mysqlURL, mysqlId, mysqlPwd);
MemberDTO memberDTO = dao.getmeMemberDTO(uId, pwd);
dao.close();

if(memberDTO.getId()!=null){
	session.setAttribute("member", memberDTO);
	response.sendRedirect("LoginSuccess.jsp");
}
else{
	response.sendRedirect("LoginFail.jsp");
}
}
%>