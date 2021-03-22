package ddit_board.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import ddit_board.vo.BoardVO;
import util.JDBCUtil;

public class BoardDaoImpl implements IBoardDao{
	
	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	@Override
	public int insertBoard(Connection conn, BoardVO bv) throws SQLException {
		int cnt = 0;
		try {
			String sql = "insert into board (board_no, board_tit, board_aut, board_cont, board_day)"
							+ "values (board_no_seq.nextval, ?, ?, ?, sysdate)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, bv.getBoardTit());
			pstmt.setString(2, bv.getBoardAut());
			pstmt.setString(3, bv.getBoardCont());
			
			cnt = pstmt.executeUpdate();
		} finally {
			JDBCUtil.disConnect(null, null, pstmt, null);
		}
		return cnt;
	}
	@Override
	public boolean checkBoard(Connection conn, String boardNo) throws SQLException {
		boolean chk = false;
		try {
			String sql = "select count(*) cnt from Board where board_no = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, boardNo);
			
			rs = pstmt.executeQuery();
			
			int cnt = 0;
			while(rs.next()) {
				cnt = rs.getInt("cnt");
			}
			
			if(cnt > 0) {
				chk = true;
			}
		} finally {
			JDBCUtil.disConnect(null, null, pstmt, rs);
		}
		
		return chk;
	}
	@Override
	public List<BoardVO> getAllBoardList(Connection conn) throws SQLException {
		List<BoardVO> boardList = new ArrayList<BoardVO>();
		
		try {
			stmt = conn.createStatement();
			
			rs = stmt.executeQuery("select * from board");
			
			while(rs.next()) {
				BoardVO bv = new BoardVO();
				String boardNo = rs.getString("board_no");
				String boardTit = rs.getString("board_tit");
				String boardAut = rs.getString("board_aut");
				String boardCont = rs.getString("board_cont");
				String boardDay = rs.getString("board_day");
				
				bv.setBoardNo(boardNo);
				bv.setBoardTit(boardTit);
				bv.setBoardAut(boardAut);
				bv.setBoardCont(boardCont);
				bv.setBoardDay(boardDay);
				
				boardList.add(bv);
			}
		}finally {
			JDBCUtil.disConnect(null, stmt, null, rs);
		}
		
		
		return boardList;
	}
	@Override
	public int updateBoard(Connection conn, BoardVO bv) throws SQLException {
		int cnt = 0;
		try {
			String sql = "update board"
					+ " set board_tit = ?"
					+ " ,board_aut = ?"
					+ " , board_cont = ?"
					+ " where board_no = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, bv.getBoardTit());
			pstmt.setString(2, bv.getBoardAut());
			pstmt.setString(3, bv.getBoardCont());
			pstmt.setString(4, bv.getBoardNo());
			
			cnt = pstmt.executeUpdate();
		} finally {
			JDBCUtil.disConnect(null, null, pstmt, null);
		}
		
		return cnt;
	}
	@Override
	public int deleteBoard(Connection conn, String boardNo) throws SQLException {
		int cnt = 0;
		try {
			String sql = "delete from board"
					+ " where board_no = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, boardNo);
			
			cnt = pstmt.executeUpdate();
		} finally {
			JDBCUtil.disConnect(null, null, pstmt, null);
		}
		
		return cnt;
	}
	@Override
	public List<BoardVO> getSearchBoard(Connection conn, BoardVO bv) throws SQLException {
			List<BoardVO> boardList = new ArrayList<>();
		
		try {
			String sql = "select * from board where 1=1";
			if(bv.getBoardNo() != null && !bv.getBoardNo().equals("")) {
				sql += "and board_no = ? ";
			}
			if(bv.getBoardTit() != null && !bv.getBoardTit().equals("")) {
				sql += "and board_tit like '%' || ? || '%' ";
			}
			if(bv.getBoardAut() != null && !bv.getBoardAut().equals("")) {
				sql += "and board_aut = ? ";
			}
			if(bv.getBoardCont() != null && !bv.getBoardCont().equals("")) {
				sql += "and board_cont like '%' || ? || '%'";
			}
			
			pstmt = conn.prepareStatement(sql);
			
			int index = 1;
			
			if(bv.getBoardNo() != null && !bv.getBoardNo().equals("")) {
				pstmt.setString(index++, bv.getBoardNo());
			}
			if(bv.getBoardTit() != null && !bv.getBoardTit().equals("")) {
				pstmt.setString(index++, bv.getBoardTit());
			}
			if(bv.getBoardAut() != null && !bv.getBoardAut().equals("")) {
				pstmt.setString(index++, bv.getBoardAut());
			}
			if(bv.getBoardCont() != null && !bv.getBoardCont().equals("")) {
				pstmt.setString(index++, bv.getBoardCont());
			}
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				BoardVO bv2 = new BoardVO();
				bv2.setBoardNo(rs.getString("board_no"));
				bv2.setBoardTit(rs.getString("board_tit"));
				bv2.setBoardAut(rs.getString("board_aut"));
				bv2.setBoardCont(rs.getString("board_cont"));
				bv2.setBoardDay(rs.getString("board_day"));
				
				boardList.add(bv2);
			}
		} finally {
			JDBCUtil.disConnect(null, null, pstmt, rs);
		}
		return boardList;
	}
	
}

