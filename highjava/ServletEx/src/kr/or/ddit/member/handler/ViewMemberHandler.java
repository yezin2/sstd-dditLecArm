package kr.or.ddit.member.handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.comm.handler.CommandHandler;
import kr.or.ddit.member.service.IMemberService;
import kr.or.ddit.member.service.MemberServiceImpl;
import kr.or.ddit.member.vo.MemberVO;
//forward
public class ViewMemberHandler implements CommandHandler{

	private static final String VIEW_PAGE = "/WEB-INF/view/member/select.jsp";
	
	@Override
	public boolean isRedirect(HttpServletRequest req) {
		return false;
	}

	@Override
	public String process(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		
		String memId = req.getParameter("memId");//사용자 정보를 화면에 뿌려주기 위함
		
		//회원 정보 조회
		IMemberService memberService = MemberServiceImpl.getInstance();
		
		MemberVO mv = memberService.getMember(memId);
		req.setAttribute("memVO", mv);
		
		
		
		
		return VIEW_PAGE;
	}

}
