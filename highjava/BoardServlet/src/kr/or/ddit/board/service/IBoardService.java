package kr.or.ddit.board.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import kr.or.ddit.board.vo.BoardVO;

/**
 * 회원정보 처리를 수행하는 서비스
 * @author pc-17
 */

public interface IBoardService {
	
	public int insertBoard(BoardVO bv);
	
	public BoardVO existBoardByboardNo(String boardNo);

	public List<BoardVO> selectAllBoard();
	
	public int updateBoard(BoardVO bv);
	
	public int deleteBoard(String boardNo);

	public List<BoardVO> selectBoardbyVO(BoardVO bv);
}
