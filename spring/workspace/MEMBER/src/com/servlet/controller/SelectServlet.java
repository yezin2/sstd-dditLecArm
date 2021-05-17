package com.servlet.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.servlet.dto.MemberVO;
import com.servlet.exception.SelecteNullpointerException;
import com.servlet.service.MemberService;
import com.servlet.service.MemberServiceImpl;

@WebServlet("/select")
public class SelectServlet extends HttpServlet {
	
	private MemberService memberService = MemberServiceImpl.getInstance();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String view = "/WEB-INF/views/selectMember.jsp";
		
		List<MemberVO> memList = null;
		String script = "";
		try {
			memList = memberService.selectMember();
		} catch (SQLException e) {
			script = "alert('서버장애로 인해 불가합니다.');"
					+ "location.href='" + request.getContextPath() + "/select';";
			e.printStackTrace();
		} catch (SelecteNullpointerException e) {
			script = "alert('"+ e.getMessage() +"');"
					+ "location.href='" + request.getContextPath() + "/select';";
		}
		
		request.setAttribute("script", script);
		request.setAttribute("memList", memList);
		request.getRequestDispatcher(view).forward(request, response);
	}
}
