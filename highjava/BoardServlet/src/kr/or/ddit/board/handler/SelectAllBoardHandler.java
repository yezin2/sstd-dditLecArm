package kr.or.ddit.board.handler;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.board.service.IBoardService;
import kr.or.ddit.board.service.BoardServiceImpl;
import kr.or.ddit.board.vo.BoardVO;
import kr.or.ddit.comm.handler.CommandHandler;

public class SelectAllBoardHandler implements CommandHandler{
	
	private static final String VIEW_PAGE = "/WEB-INF/view/board/selectAllBoard.jsp";
	@Override
	public boolean isRedirect(HttpServletRequest req) {
		
		return false;
	}

	@Override
	public String process(HttpServletRequest req, HttpServletResponse resp) {

		//1. 서비스 객체 생성하기
		IBoardService boardService = BoardServiceImpl.getInstance();
		
		//2. 회원정보 조회
		List<BoardVO> boardList = boardService.selectAllBoard();
		
		req.setAttribute("boardList",boardList);
		
		return VIEW_PAGE;
	}

}
