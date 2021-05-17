package kr.or.ddit.board.dao;

import java.sql.Connection;
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
	
	public int insertBoard(SqlMapClient smc, BoardVO bv) throws SQLException;
	
	
	public BoardVO existBoardByboardNo(SqlMapClient smc, String boardNo) throws SQLException;
	
	
	public List<BoardVO> selectAllBoard(SqlMapClient smc) throws SQLException;


	public int updateBoard(SqlMapClient smc, BoardVO bv) throws SQLException;
	

	public int deleteBoard(SqlMapClient smc, String boardNo) throws SQLException;
	

	public List<BoardVO> selectBoardbyVO(SqlMapClient smc, BoardVO bv) throws SQLException;
}
