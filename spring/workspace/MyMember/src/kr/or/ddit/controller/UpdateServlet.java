package kr.or.ddit.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.dto.MemberVO;
import kr.or.ddit.exception.FailedUpdateException;
import kr.or.ddit.exception.SelecteNullpointerException;
import kr.or.ddit.service.MemberService;
import kr.or.ddit.service.MemberServiceImpl;

@WebServlet("/update")
public class UpdateServlet extends HttpServlet {

	private MemberService memberService = new MemberServiceImpl();
	public void setMemberService(MemberService memberService) {
		this.memberService = memberService;
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		
		String view = "/WEB-INF/views/updateMember.jsp";
		String id = request.getParameter("id");
		
		MemberVO mv = null;
		String script = "";
		
		try {
			mv = (MemberVO)memberService.existMemberByid(id);
		} catch (SQLException e) {
			script = "alert('서버장애로 인해 불가합니다.');"
					+ "location.href='" + request.getContextPath() + "/select';";
		} catch (SelecteNullpointerException e) {
			script = "alert('"+ e.getMessage() +"');"
					+ "location.href='" + request.getContextPath() + "/select';";
		}
		
		request.setAttribute("script", script);
		request.setAttribute("mv", mv);
		request.getRequestDispatcher(view).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String view = "/WEB-INF/views/updateMember.jsp";
		
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
		int updateResult = 0;
		
		try {
			updateResult = memberService.updateMember(mv);
			if(updateResult > 0) {
				script = "alert('수정 성공!');"
					+ "location.href='" + request.getContextPath() + "/select';";
			}
		} catch (SQLException e) {
			script = "alert('서버장애로 인해 불가합니다.');"
					+ "location.href='" + request.getContextPath() + "/select';";
			e.printStackTrace();
		} catch (FailedUpdateException e) {
			script = "alert('"+ e.getMessage() +"');"
					+ "location.href='" + request.getContextPath() + "/select';";
		}
		request.setAttribute("mv", mv);
		request.setAttribute("script", script);
		request.getRequestDispatcher(view).forward(request, response);
	}

}
