package edu.pnu.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class MyServlet05 extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public void service(HttpServletRequest req, HttpServletResponse res) throws IOException {
		System.out.println("myservlet05");
		res.setContentType("text/html; charset=utf-8");
		PrintWriter out = res.getWriter();
		out.println("<style>\r\n"
				+ "table, th, td {\r\n"
				+ "  border:1px solid black;\r\n"
				+ "}\r\n"
				+ "</style>"
				+ "<table>\r\n"
				+ "    <tr>\r\n"
				+ "        <th>번호</th>\r\n"
				+ "        <th>나라</th>\r\n"
				+ "        <th>수도</th>\r\n"
				+ "        <th>인구</th>\r\n"
				+ "    </tr>\r\n"
				+ "    <tr>\r\n"
				+ "        <td>1</td>\r\n"
				+ "        <td>대한민국</td>\r\n"
				+ "        <td>서울</td>\r\n"
				+ "        <td>1000만</td>\r\n"
				+ "    </tr>\r\n"
				+ "    <tr>\r\n"
				+ "        <td>2</td>\r\n"
				+ "        <td>미국</td>\r\n"
				+ "        <td>워싱턴</td>\r\n"
				+ "        <td>70만</td>\r\n"
				+ "    </tr>\r\n"
				+ "    <tr>\r\n"
				+ "        <td>3</td>\r\n"
				+ "        <td>일본</td>\r\n"
				+ "        <td>도쿄</td>\r\n"
				+ "        <td>1400만</td>\r\n"
				+ "    </tr>\r\n"
				+ "    <tr>\r\n"
				+ "        <td>4</td>\r\n"
				+ "        <td>중국</td>\r\n"
				+ "        <td>베이징</td>\r\n"
				+ "        <td>2100만</td>\r\n"
				+ "    </tr>\r\n"
				
				+ "</table>");
		out.close();
	}
}
