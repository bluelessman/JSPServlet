<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>유클리드메인</title>
</head>
<body>
<%
int n1 = Integer.parseInt(request.getParameter("n1"));
int n2 = Integer.parseInt(request.getParameter("n2"));
int max = Math.max(n1,n2);
int min = n1+n2-max;
while(max%min!=0){
	int temp = max%min;
	max = min;
	min = temp;
}
int GCD = min;
int LCM = n1*n2/GCD;
response.sendRedirect("uclid.jsp?GCD="+GCD+"&LCM="+LCM);
%>
</body>
</html>