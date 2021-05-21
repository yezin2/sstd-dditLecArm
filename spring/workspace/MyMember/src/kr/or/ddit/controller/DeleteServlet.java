package kr.or.ddit.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.dto.MemberVO;
import kr.or.ddit.exception.FailedDeleteException;
import kr.or.ddit.exception.SelecteNullpointerException;
import kr.or.ddit.service.MemberService;
import kr.or.ddit.service.MemberServiceImpl;

@WebServlet("/delete")
public class DeleteServlet extends HttpServlet {

	private MemberService memberService = MemberServiceImpl.getInstance();
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		
		String view = "/WEB-INF/views/deleteMember.jsp";
		String id = request.getParameter("id");
		
		int deleteResult = 0;
		String script = "";
		
		try {
			deleteResult = memberService.deleteMember(id);
			if(deleteResult > 0) {
				script = "alert('삭제 성공!');"
					+ "location.href='" + request.getContextPath() + "/select';";
			}
		} catch (SQLException e) {
			script = "alert('서버장애로 인해 불가합니다.');"
					+ "location.href='" + request.getContextPath() + "/select';";
		} catch (FailedDeleteException e) {
			script = "alert('"+ e.getMessage() +"');"
					+ "location.href='" + request.getContextPath() + "/select';";
		}
		
		request.setAttribute("script", script);
		request.getRequestDispatcher(view).forward(request, response);
	}
}
