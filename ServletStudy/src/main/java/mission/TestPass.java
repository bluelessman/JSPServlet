package mission;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/JSPMission/TestPass.do")
public class TestPass extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int guk = Integer.parseInt(req.getParameter("guk"));
		int eng = Integer.parseInt(req.getParameter("eng"));
		int math = Integer.parseInt(req.getParameter("math"));
		int avg = (guk+eng+math)/3;
		if(avg>=60) {
			req.setAttribute("message", "합격입니다. 평균 : "+avg);

		}else {
			req.setAttribute("message", "불합격입니다. 평균 : "+avg);
		}
		req.getRequestDispatcher("/JSPMission/TestPass.jsp").forward(req, resp);
	}

}
