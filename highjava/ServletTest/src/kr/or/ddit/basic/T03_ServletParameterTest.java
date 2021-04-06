package kr.or.ddit.basic;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class T03_ServletParameterTest extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		/**
		 * 요청 객체로부터 파라미터 데이터 가져오는 방법
		 * - getParameter() : 파라미터 값이 한개인 경우에 가져올 때 사용함.
		 * - getParameterValues() : 파라미터 값이 여러개인 경우. ex) checkbox
		 * - getParameterNames() : request에 존재하는 모든 파라미터 정보를 가져올때 사용함.
		 */
		
		req.setCharacterEncoding("UTF-8");
		
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		String gender = req.getParameter("gender");
		String hobby = req.getParameter("hobby");
		String rlgn = req.getParameter("password");
		String[] food = req.getParameterValues("food");
		
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html");
		
		PrintWriter out = resp.getWriter();
		out.println("<html>");
		out.println("<body>");
		out.println("<p>username : " + username + "</p>");
		out.println("<p>password : " + password + "</p>");
		out.println("<p>gender : " + gender + "</p>");
		out.println("<p>hobby : " + hobby + "</p>");
		
		out.println("<p>rlgn : " + rlgn + "</p>");
		
		if(food != null) {
			for(String s : food) {
				out.println("<p>food : " + s + "</p>");
			}
		}
		
		Enumeration<String> params = req.getParameterNames();//like iterator
		while (params.hasMoreElements()) {
			String param = params.nextElement();
			out.println("<p>파라미터 이름 : " + param + "</p>");
		}
		out.println("</body>");
		out.println("</html>");
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
