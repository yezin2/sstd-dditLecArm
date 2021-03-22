package ddit_board.service;

import java.util.List;
import ddit_board.vo.BoardVO;

/**
 * 게시물 정보처리를 수행하는 서비스
 * @author PC-17
 *
 */
public interface IBoardService {
	/**
	 * 게시물 등록하는 메서드
	 * @param bv DB에 insert할 자료가 저장된 BoardVO객체
	 * @return 작업성공: 1, 작업실패: 0
	 */
	public int insertBoard(BoardVO bv);
	
	/**
	 * 주어진 게시물 번호가 존재하는지 여부를 알아내는 메서드
	 * @param boardNo 게시물 번호
	 * @return 게시물 번호가 존재하면 true, 존재하지 않으면 false
	 */
	public boolean checkBoard(String boardNo);
	
	/**
	 * 전체 게시물 정보 조회 메서드
	 * @return 게시물 정보를 담고있는 List객체
	 */
	public List<BoardVO> getAllBoardList();
	
	/**
	 * 하나의 게시물 정보를 수정하는 메서드
	 * @param bv 게시물 정보 객체
	 * @return 작업성공: 1, 작업실패: 0
	 */
	public int updateBoard(BoardVO bv);
	
	/**
	 * 게시물 정보를 삭제하는 메서드
	 * @param boardNo 게시물 번호
	 * @return 작업성공 : 1, 작업실패: 0 
	 */
	public int deleteBoard(String boardNo);

	/**
	 * 게시물 정보를 검색
	 * @param bv
	 * @return
	 */
	public List<BoardVO> getSearchBoard(BoardVO bv);
}
