<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="common.JDBConnect"%>
 <%@page import="membership.MemberDTO"%>
<%
JDBConnect jdbc = new JDBConnect();
String title = request.getParameter("title");
String content = request.getParameter("content");
String bId = request.getParameter("bId");

String sql = "insert into board(title,content,id) values(?,?,?)";
PreparedStatement psmt = jdbc.getCon().prepareStatement(sql);
psmt.setString(1, title);
psmt.setString(2, content);
psmt.setString(3, bId);
try{
	int inResult = psmt.executeUpdate();
	response.sendRedirect("InsertBoardSuccess.jsp?result="+inResult);
}catch(Exception e){
	request.setAttribute("errMsg", e.getMessage());
	request.getRequestDispatcher("InsertBoardFail.jsp").forward(request, response);
}finally{
	if(psmt!=null) psmt.close();
	jdbc.close();
}
%>
