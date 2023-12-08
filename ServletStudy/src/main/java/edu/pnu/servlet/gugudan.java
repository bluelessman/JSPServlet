package edu.pnu.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class gugudan extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void service(HttpServletRequest req, HttpServletResponse res) throws IOException {
		System.out.println("gugudan");
		res.setContentType("text/plain; charset=utf-8");
		PrintWriter out = res.getWriter();
		String num = req.getParameter("num");
		String dir = req.getParameter("dir");
		String dan = req.getParameter("dan");
		if (num != null) {
			numGu(res, num);
		} else if (dir != null) {
			dirGu(res, dir);
		} else if (dan != null) {
			danGu(res, dan);
		} else {
			numGu(res, "2");
		}

//		String dir = req.getParameter("dir");
//		for (num = 2; num < 10; num++) {
//			str += "<div><h1>" + num + "단입니다.</h1><ul>";
//			for (int i = 1; i <= 9; i++) {
//				str += "<li>" + num + " * " + i + " = " + num * i;
//			}
//			str += "<ul></div>";
//		}
//		String c = "";
//		if (dir != null) {
//			if (dir.compareTo("hor") == 0) {
//				c = "<style>div{float: left;}</style>";
//			}else {
//				c = "";
//			}
//		}else {
//			c="";
//		}
		out.close();
	}

	private void danGu(HttpServletResponse res, String dan) throws IOException {
		// TODO Auto-generated method stub

		String[][] gugu = makeGu();
		PrintWriter out = res.getWriter();
		String str = "";
		int n = Integer.parseInt(dan);
		int k = 0;
		int j = 0;
		while (true) {
			for (int i = 0; i < 10; i++) {
				for (j = k; j < n + k && j < 8; j++) {
					str = gugu[j][i];
					out.print(str + "\t");
				}
				out.println();
			}
			if (j == 8)
				return;
			k = k + n;
		}
	}

	private String[][] makeGu() {
		String[][] gugu = new String[8][10];
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 10; j++) {
				if (j == 0) {
					gugu[i][j] = (i + 2) + "단입니다~~~~~";
				} else {
					gugu[i][j] = (i + 2) + " * " + j + " = " + (i + 2) * j;
				}
			}
		}
		return gugu;
	}

//
	private void dirGu(HttpServletResponse res, String dir) throws IOException {
		// TODO Auto-generated method stub
		String[][] gugu = makeGu();
		PrintWriter out = res.getWriter();
		String str = "";
		if (dir.compareTo("ver") == 0) {
			for (int i = 0; i < 8; i++) {
				for (int j = 0; j < 10; j++) {
					str = gugu[i][j];
					out.println(str);
				}
				out.println();
			}
		} else {
			for (int i = 0; i < 10; i++) {
				for (int j = 0; j < 8; j++) {
					str = gugu[j][i];
					out.print(str + "\t");
				}
				out.println();
			}
		}
		out.close();

	}

	private void numGu(HttpServletResponse res, String num) throws IOException {
		// TODO Auto-generated method stub
		int n = Integer.parseInt(num);
		String str = num + "단입니다.";
		PrintWriter out = res.getWriter();
		out.println(str);
		for (int i = 1; i <= 9; i++) {
			str = n + " * " + i + " = " + n * i;
			out.println(str);
		}
		out.close();
	}

}
