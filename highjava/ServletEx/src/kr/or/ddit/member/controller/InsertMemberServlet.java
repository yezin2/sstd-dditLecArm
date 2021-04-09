package kr.or.ddit.member.controller;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.member.service.IMemberService;
import kr.or.ddit.member.service.MemberServiceImpl;
import kr.or.ddit.member.vo.MemberVO;

public class InsertMemberServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher dispatcher = req.getRequestDispatcher("/member/insertForm.jsp");
		dispatcher.forward(req, resp);
		// forward는 서버안에서 뱅뱅 돌면서 작업하기 때문에 url이 바뀌지 않음
		// redirect는 forward랑 다른 흐름으로 다른 페이지로 던져주기 때문에 url이 변경됨
		
		
	}
	@Override
	//데이터가 많은 경우는 post방식을 사용함
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 1. 요청 파라미터 정보 가져오기
		String memId = req.getParameter("memId");
		String memName = req.getParameter("memName");
		String memTel = req.getParameter("memTel");
		String memAddr = req.getParameter("memAddr");
		
		// 2. 서비스 객체 생성하기
		IMemberService memberservice = MemberServiceImpl.getInstance();
		
		// 3. 회원 정보 등록하기
		MemberVO mv = new MemberVO();
		mv.setMemId(memId);
		mv.setMemName(memName);
		mv.setMemTel(memTel);
		mv.setMemAddr(memAddr);
		
		int cnt = memberservice.insertMember(mv);
		
		String msg = "";
		if(cnt > 0) {
			msg = "성공";
		} else {
			msg = "실패";
		}
		
		// 4. 목록 조회화면으로 이동
		// status : 302일경우 만들어지는 헤더에 
		// 			Location: /ServletEx/member/list.do?msg=%EC%84%B1%EA%B3%B5이 생김
		// getRequestDispatcher()에서는 이미 getContextPath()를 포함하고 있기 때문에 써줄 필요 없슴
		String redirectUrl = req.getContextPath() + "/member/list.do?msg=" + URLEncoder.encode(msg, "UTF-8");
		//redirect는  insert.do와 list.do를 모두 요청함
		resp.sendRedirect(redirectUrl);
		//getRequestDispatcher는 insert.do만 요청해서 그 안에서 작업 처리됨
//		req.getRequestDispatcher("/member/list.do?msg="+ URLEncoder.encode(msg, "UTF-8")).forward(req, resp);
	}
}
