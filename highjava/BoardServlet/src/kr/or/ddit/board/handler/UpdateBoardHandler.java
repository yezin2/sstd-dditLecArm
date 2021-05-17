package kr.or.ddit.board.handler;

import java.net.URLEncoder;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;

import kr.or.ddit.board.service.IBoardService;
import kr.or.ddit.board.service.BoardServiceImpl;
import kr.or.ddit.board.vo.AtchFileVO;
import kr.or.ddit.board.vo.BoardVO;
import kr.or.ddit.comm.handler.CommandHandler;
import kr.or.ddit.comm.service.AtchFileServiceImpl;
import kr.or.ddit.comm.service.IAtchFileService;
import kr.or.ddit.util.FileUploadRequestWrapper;

public class UpdateBoardHandler implements CommandHandler{

	private static final String VIEW_PAGE = "/WEB-INF/view/board/updateBoard.jsp";
	@Override
	public boolean isRedirect(HttpServletRequest req) {
		if(req.getMethod().equals("GET")) { // GET 방식인 경우 redirect를 하지 않는다.
			return false;
		}else { // POST 방식인 경우
			return true;
		}
	}

	@Override
	public String process(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		if(req.getMethod().equals("GET")){
			String boardNo = req.getParameter("boardNo");
			
			//1-1 회원 정보 조회
			IBoardService boardService = BoardServiceImpl.getInstance();
			
			BoardVO bv = boardService.existBoardByboardNo(boardNo);
			
			//2. 모델정보 등록
			req.setAttribute("bv", bv);
			return VIEW_PAGE;
		}else {	//POST 방식인 경우
			
//			FileItem item = ((FileUploadRequestWrapper)req).getFileItem("atchFile");
			
//			AtchFileVO atchFileVO = new AtchFileVO();
			
//			//기존의 첨부파일 아이디 정보 가져오기
//			atchFileVO.setAtchFileId(req.getParameter("atchFile") == null ? 
//					-1 : Long.parseLong(req.getParameter("atchFile")));
//			
//			if(item != null && !item.getName().equals("")) {
//				IAtchFileService fileService = AtchFileServiceImpl.getInstance();
//				
//				atchFileVO = fileService.saveAtchFile(item); // 첨부파일 저장
//				
//			}
			
			//1. 요청 파라미터 정보 가져오기
			String boardNo = req.getParameter("boardNo");
			String boardTitle = req.getParameter("boardTitle");
			String boardAuthor = req.getParameter("boardAuthor");
			String boardContent = req.getParameter("boardContent");
			
			IBoardService boardService = BoardServiceImpl.getInstance();
			BoardVO bv = new BoardVO();
			
			bv.setBoardNo(boardNo);
			bv.setBoardTitle(boardTitle);
			bv.setBoardAuthor(boardAuthor);
			bv.setBoardContent(boardContent);
//			bv.setAtchFileId(atchFileVO.getAtchFileId());
			
			int cnt = boardService.updateBoard(bv);
			
			String msg="";
			if(cnt > 0) {
				msg = "성공";
			}else {
				msg="실패";
			}
			
			// 4. 목록 조회화면으로 이동
			String redirectUrl = req.getContextPath() + "/selectAllBoard.do?msg=" + URLEncoder.encode(msg, "UTF-8");
			return redirectUrl;
		}
	}

}
