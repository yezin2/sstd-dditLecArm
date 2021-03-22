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

public class BoardDaoImpl implements IboardDao{

	private static IboardDao memDao;
	
	private BoardDaoImpl() { }
	public static IboardDao getInstance() {
		if(memDao == null) {
			memDao = new BoardDaoImpl();
		}
		return memDao;
	}
	@Override
	public int insertMember(SqlMapClient smc, BoardVO mv) throws SQLException {
		int cnt = 0;
		Object obj = smc.insert("member.insertMember", mv);
		if(obj == null) {
			cnt = 1;
		}
		
		return cnt;
	}

	@Override
	public boolean checkMember(SqlMapClient smc, String memId) throws SQLException {
		boolean chk = false;
		int cnt = (int) smc.queryForObject("member.getMember", memId);
		if(cnt > 0) {
			chk = true;
		}		
		return chk;
	}

	@Override
	public List<BoardVO> getAllMemberList(SqlMapClient smc) throws SQLException {
		
		List<BoardVO> memList = smc.queryForList("member.getMemberAll");
		
		return memList;
	}

	@Override
	public int updateMember(SqlMapClient smc, BoardVO mv) throws SQLException {
		int cnt = smc.update("member.updateMember", mv);
		
		
		return cnt;
	}

	@Override
	public int deleteMember(SqlMapClient smc, String memId) throws SQLException {
		int cnt = smc.delete("member.deleteMember", memId);
		
		
		return cnt;
	}

	@Override
	public List<BoardVO> getSearchMember(SqlMapClient smc, BoardVO mv) throws SQLException {
		List<BoardVO> memList = smc.queryForList("member.getSearchMember", mv);
		
		return memList;
	}
	
	
}
