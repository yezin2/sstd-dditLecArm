package com.servlet.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.servlet.dto.MemberVO;
import com.servlet.exception.FailedInsertException;
import com.servlet.service.MemberService;
import com.servlet.service.MemberServiceImpl;

@WebServlet("/insert")
public class InsertServlet extends HttpServlet {
	
	private MemberService memberService = MemberServiceImpl.getInstance();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String view = "/WEB-INF/views/insertMember.jsp";
		request.getRequestDispatcher(view).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		String view = "/WEB-INF/views/insertMember.jsp";
		
		String id = (String)request.getParameter("id");
		String pwd = (String)request.getParameter("pwd");
		String name = (String)request.getParameter("name");
		String email = (String)request.getParameter("email");
		String phone = (String)request.getParameter("phone");
		
		MemberVO mv = new MemberVO();
		
		mv.setId(id);
		mv.setPwd(pwd);
		mv.setName(name);
		mv.setEmail(email);
		mv.setPhone(phone);
		
		String script = "";
		int insertResult = 0;
		
		try {
			insertResult = memberService.insertMember(mv);
			if(insertResult > 0) {
				script = "alert('등록 성공!');"
					+ "location.href='" + request.getContextPath() + "/select';";
			}
		} catch (SQLException e) {
			script = "alert('서버장애로 인해 불가합니다.');"
					+ "location.href='" + request.getContextPath() + "/select';";
			e.printStackTrace();
		} catch (FailedInsertException e) {
			script = "alert('"+ e.getMessage() +"');"
					+ "location.href='" + request.getContextPath() + "/select';";
		}
		request.setAttribute("script", script);
		request.getRequestDispatcher(view).forward(request, response);
	}

}
