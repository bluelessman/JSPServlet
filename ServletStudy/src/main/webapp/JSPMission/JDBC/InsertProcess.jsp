<%@page import="java.sql.PreparedStatement"%>
<%@page import="jakarta.servlet.jsp.tagext.TryCatchFinally"%>
<%@page import="common.JDBConnect"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>misson6</title>
</head>
<body>
<h2>insertprocess</h2>
<%
JDBConnect jdbc = new JDBConnect();
String id = request.getParameter("id");
String pass = request.getParameter("pass");
String name = request.getParameter("name");
String sql = "insert into member(id,pass,name) values(?,?,?)";
PreparedStatement psmt = jdbc.getCon().prepareStatement(sql);
psmt.setString(1, id);
psmt.setString(2, pass);
psmt.setString(3, name);
try{
	int inResult = psmt.executeUpdate();
	request.getRequestDispatcher("InsertSuccess.jsp").forward(request, response);
}catch (Exception e) {
	// TODO: handle exception
	request.getRequestDispatcher("InsertFail.jsp?msg="+e.getMessage()).forward(request, response);
}finally{
psmt.close();
jdbc.close();
}
%>
</body>
</html>