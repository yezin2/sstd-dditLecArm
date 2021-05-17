package kr.or.ddit.board.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.board.vo.BoardVO;
import kr.or.ddit.util.SqlMapClientUtil;
import util.JDBCUtil;

public class BoardDaoImpl implements IBoardDao{

	private static IBoardDao boardDao;
	
	private BoardDaoImpl() { }
	public static IBoardDao getInstance() {
		if(boardDao == null) {
			boardDao = new BoardDaoImpl();
		}
		return boardDao;
	}

	@Override
	public int insertBoard(SqlMapClient smc, BoardVO bv) throws SQLException {
		int cnt = 0;
		Object obj = smc.insert("board.insertBoard", bv);
		if(obj == null) {
			cnt = 1;
		}
		return cnt;
	}
	@Override
	public BoardVO existBoardByboardNo(SqlMapClient smc, String boardNo) throws SQLException {
		BoardVO bv =  (BoardVO) smc.queryForObject("board.existBoardByboardNo", boardNo);
		return bv;
	}
	@Override
	public List<BoardVO> selectAllBoard(SqlMapClient smc) throws SQLException {
		List<BoardVO> boardList = smc.queryForList("board.selectAllBoard");
		return boardList;
	}
	@Override
	public int updateBoard(SqlMapClient smc, BoardVO bv) throws SQLException {
		int cnt = smc.update("board.updateBoard", bv);
		return cnt;
	}
	@Override
	public int deleteBoard(SqlMapClient smc, String boardNo) throws SQLException {
		int cnt = smc.delete("board.deleteBoard", boardNo);
		return cnt;
	}
	@Override
	public List<BoardVO> selectBoardbyVO(SqlMapClient smc, BoardVO bv) throws SQLException {
		List<BoardVO> boardList = smc.queryForList("board.selectBoardbyVO", bv);
		
		return boardList;
	}
	
	
}
