package ddit_board.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import ddit_board.vo.BoardVO;

/**
 * 실제 DB와 연결해서 SQL문을 수행하여 결과를 작성하여 서비스에 전달하는 DAO인터페이스
 * @author PC-17
 */
public interface IBoardDao {
	/**
	 * BoardVO객체에 담겨진 자료를 DB에 insert
	 * @param conn - 커넥션객체
	 * @param bv - DB에 insert할 자료가 저장된 BoardVO객체
	 * @return 작업성공: 1, 작업실패: 0
	 * @throws SQLException - JDBC관련 예외객체 발생
	 */
	public int insertBoard(Connection conn, BoardVO bv) throws SQLException;
	
	/**
	 * 주어진 게시물 번호가 존재하는지 여부를 알아내는 메서드
	 * @param conn - 커넥션객체
	 * @param boardNo - 게시물 번호
	 * @return 해당 회원ID가 존재하면 true, 존재하지 않으면 false
	 * @throws SQLException - JDBC관련 예외객체 발생
	 */
	public boolean checkBoard(Connection conn, String boardNo) throws SQLException;
	
	/**
	 * DB의 board테이블의 전체 레코드를 가져와서 List에 담아 반환하는 메서드
	 * @param conn - 커넥션객체
	 * @return 회원정보를 담고있는 List객체
	 * @throws SQLException - JDBC관련 예외객체
	 */
	public List<BoardVO> getAllBoardList(Connection conn) throws SQLException;
	
	/**
	 * 하나의 게시물 정보를 이용하여 DB를 update하는 메서드
	 * @param conn - 커넥션객체
	 * @param bv - BoardVO객체
	 * @return 작업성공: 1, 작업실패: 0
	 * @throws SQLException - JDBC관련 예외객체
	 */
	public int updateBoard(Connection conn, BoardVO bv) throws SQLException;
	
	/**
	 * 게시물 번호를 매개변수로 받아서 그 게시물 정보를 삭제하는 메서드
	 * @param conn - 커넥션객체
	 * @param boardNo - 게시물 번호
	 * @return 작업성공: 1, 작업실패: 0
	 * @throws SQLException - JDBC관련 예외객체
	 */
	public int deleteBoard(Connection conn, String boardNo) throws SQLException;
	
	/**
	 * BoardVO 객체에 담긴 자료를 이용하여 회원을 검색하는 메서드
	 * @param conn - 커넥션객체
	 * @param bv - BoardVO객체
	 * @return 검색된 결과를 담은 List
	 * @throws SQLException - JDBC관련 예외객체
	 */
	public List<BoardVO> getSearchBoard (Connection conn, BoardVO bv) throws SQLException;
	
}