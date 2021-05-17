package kr.or.ddit.board.handler;

import java.net.URLEncoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.board.service.IBoardService;
import kr.or.ddit.board.service.BoardServiceImpl;
import kr.or.ddit.comm.handler.CommandHandler;
//redirect 필요
public class DeleteBoardHandler implements CommandHandler{

	@Override
	public boolean isRedirect(HttpServletRequest req) {
		return true;
	}

	@Override
	public String process(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		// 1. 요청 파라미터 정보 가져오기
		String boardNo = req.getParameter("boardNo");
			
		// 2. 삭제처리
		IBoardService boardService = BoardServiceImpl.getInstance();
		
		int cnt = boardService.deleteBoard(boardNo);
		
		String msg ="";
		
		if(cnt > 0) {
			msg = "성공";
		} else {
			msg = "실패";
		}
		
		// 4. 목록 조회화면으로 이동
		String redirectUrl = req.getContextPath() + "/selectAllBoard.do?msg=" + URLEncoder.encode(msg, "UTF-8");
		
		return redirectUrl;
	}

}
