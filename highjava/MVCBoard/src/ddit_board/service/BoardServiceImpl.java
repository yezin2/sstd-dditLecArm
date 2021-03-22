package ddit_board.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ddit_board.dao.BoardDaoImpl;
import ddit_board.dao.IBoardDao;
import ddit_board.vo.BoardVO;
import util.JDBCUtil3;

public class BoardServiceImpl implements IBoardService{
	private IBoardDao boardDao;
	private Connection conn;
	
	public BoardServiceImpl() {
		boardDao = new BoardDaoImpl();
	}
	
	@Override
	public int insertBoard(BoardVO bv) {
		int cnt = 0;
		
		try {
			conn = JDBCUtil3.getConnection();
			cnt = boardDao.insertBoard(conn, bv);
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil3.disConnect(conn, null, null, null);
		}
		return cnt;
	}
	@Override
	public boolean checkBoard(String boardNo) {
		boolean chk = false;
		
		
		try {
			conn = JDBCUtil3.getConnection();
			chk = boardDao.checkBoard(conn, boardNo);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil3.disConnect(conn, null, null, null);
		}
		return chk;
	}
	
	@Override
	public List<BoardVO> getAllBoardList() {
		List<BoardVO> boardList = new ArrayList<BoardVO>();
		try {
			conn = JDBCUtil3.getConnection();
			boardList = boardDao.getAllBoardList(conn);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil3.disConnect(conn, null, null, null);
		}
		return boardList;
	}
	
	@Override
	public int updateBoard(BoardVO bv) {
		int cnt = 0;
		try {
			conn = JDBCUtil3.getConnection();
			cnt = boardDao.updateBoard(conn, bv);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil3.disConnect(conn, null, null, null);
		}
		return cnt;
	}
	@Override
	public int deleteBoard(String boardNo) {
		int cnt = 0;
		try {
			conn = JDBCUtil3.getConnection();
			cnt = boardDao.deleteBoard(conn, boardNo);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCUtil3.disConnect(conn, null, null, null);
		}
		return cnt;
	}
	@Override
	public List<BoardVO> getSearchBoard(BoardVO bv) {
		List<BoardVO> boardList = new ArrayList<>();
		
		try {
			conn = JDBCUtil3.getConnection();
			boardList = boardDao.getSearchBoard(conn, bv);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil3.disConnect(conn, null, null, null);
		}
		return boardList;
	}
	
	
	
}
