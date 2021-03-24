package kr.or.ddit.board.dao;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.board.vo.BoardVO;

/**
 * 실제 DB와 연결해서 SQL문을 수행하여 결과를 작성하여 서비스에 전달하는 DAO 인터페이스
 * @author pc-17
 *
 */
public interface IBoardDao {
	
	/**
	 * BoardVO 객체에 담겨진 자료를 DB에 insert하는 메서드
	 * @param smc SqlMapClient 객체
	 * @param mv DB에 insert할 자료가 저장된 BoardVO객체
	 * @return 작업성공: 1, 작업실패: 0
	 * @throws SQLException JDBC관련 예외객체 발생
	 */
	public int insertBoard(SqlMapClient smc, BoardVO bv) 
			 			throws SQLException;
	
	/**
	 * 주어진 게시물 번호가 존재하는지 여부를 알아내는 메서드
	 * @param smc SqlMapClient 객체
	 * @param boardNo 게시물 번호
	 * @return 해당 게시물 번호가 존재하면 true, 존재하지 않으면 false
	 * @throws SQLException JDBC관련 예외객체 발생
	 */
	public boolean checkBoard(SqlMapClient smc, String boardNo)
						throws SQLException;
	
	/**
	 * DB의 board테이블의 전체 레코드를 가져와서 List에 담아 반환하는 메서드
	 * @param smc SqlMapClient 객체
	 * @return 게시물정보를 담고있는 List객체
	 * @throws SQLException JDBC관련 예외객체
	 */
	public List<BoardVO> getAllBoardList(SqlMapClient smc)
	 					throws SQLException;
	
	/**
	 * 하나의 게시물정보를 이용하여 DB를 update하는 메서드
	 * @param smc SqlMapClient 객체
	 * @param bv 게시물 정보 객체
	 * @return 작업성공: 1, 작업실패: 0
	 * @throws SQLException JDBC 예외객체
	 */
	public int updateBoard(SqlMapClient smc, BoardVO bv)
						throws SQLException;
	
	/**
	 * 게시물 번호를 매개변수로 받아서 그 게시물 정보를 삭제하는 메서드
	 * @param smc SqlMapClient 객체
	 * @param boardNo 삭제할 게시물 번호
	 * @return 작업성공 : 1, 작업실패: 0 
	 * @throws SQLException JDBC관련 예외 객체
	 */
	public int deleteBoard(SqlMapClient smc, String boardNo)
						throws SQLException;
	
	/**
	 * BoardVO 객체에 담긴 자료를 이용하여 회원을 검색하는 메서드
	 * @param smc SqlMapClient 객체
	 * @param bv 검색할 자료가 들어있는 BoardVO객체
	 * @return 검색된 결과를 담은 List
	 * @throws SQLException JDBC관련 예외 객체
	 */
	public List<BoardVO> getSearchBoard(SqlMapClient smc, BoardVO bv)
						throws SQLException;
}
