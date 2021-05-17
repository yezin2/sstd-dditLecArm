package kr.or.ddit.board.handler;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.board.service.IBoardService;
import kr.or.ddit.board.service.BoardServiceImpl;
import kr.or.ddit.board.vo.AtchFileVO;
import kr.or.ddit.board.vo.BoardVO;
import kr.or.ddit.comm.handler.CommandHandler;
import kr.or.ddit.comm.service.AtchFileServiceImpl;
import kr.or.ddit.comm.service.IAtchFileService;
//forward
public class SelectBoardbyVOHandler implements CommandHandler{

	private static final String VIEW_PAGE = "/WEB-INF/view/board/selectAllBoard.jsp";
	
	@Override
	public boolean isRedirect(HttpServletRequest req) {
		return false;
	}

	@Override
	public String process(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		
		String boardNo = req.getParameter("boardNo");
		String boardTitle = req.getParameter("boardTitle");
		String boardAuthor = req.getParameter("boardAuthor");
		
		IBoardService boardService = BoardServiceImpl.getInstance();
		BoardVO bv = new BoardVO();
		
		bv.setBoardNo(boardNo);
		bv.setBoardTitle(boardTitle);
		bv.setBoardAuthor(boardAuthor);
		
		List<BoardVO> boardList = boardService.selectBoardbyVO(bv);
		
		
		req.setAttribute("boardList", boardList);
		return VIEW_PAGE;
	}

}
