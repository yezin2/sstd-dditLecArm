package com.servlet.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.servlet.dto.MemberVO;
import com.servlet.exception.InvalidPasswordException;
import com.servlet.exception.NotFoundIDException;
import com.servlet.service.MemberService;
import com.servlet.view.HTMLView;

@WebServlet("/login")
public class LoginServlet extends HttpServlet{
	
	private MemberService memberService = new MemberService() {
		
		@Override
		public MemberVO login(String id, String pwd) throws NotFoundIDException, InvalidPasswordException, SQLException {
			// TODO Auto-generated method stub
			return null;
		}
	};
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String view = "/WEB-INF/views/login.jsp";
		
		//		HTMLView.loginView(resp);
		req.getRequestDispatcher(view).forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//화면 url
		String view = "/WEB-INF/views/login_success.jsp";
		
		//입력
		String id = req.getParameter("id");
		String pwd = req.getParameter("pwd");
		
		//처리
		String script = "";
		//memService.login(id,pwd) : memberVO, InvalidPasswordException, NotFoundIDException
		try {
			memberService.login(id, pwd);
			
			script = "alert('로그인 성공!');"
					+ "location.href='" + req.getContextPath() + "/main'";
		} catch (NotFoundIDException e) {
			script = "alert('"+ e.getMessage() +"');"
					+ "history.go(-1);";
		} catch (InvalidPasswordException e) {
			script = "alert('"+ e.getMessage() +"');"
					+ "history.go(-1);";
		} catch (SQLException e) {
			script = "alert('서버장애로 인해 불가합니다.');"
					+ "location.href='" + req.getContextPath() + "/main';";
			e.printStackTrace();
		}
		
		//출력
		//HTMLView.html(resp, script);
		
		req.setAttribute("script", script);
		req.getRequestDispatcher(view).forward(req, resp);
	}
}
