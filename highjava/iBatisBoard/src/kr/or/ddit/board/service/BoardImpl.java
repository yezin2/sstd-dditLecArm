package kr.or.ddit.board.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.board.dao.IboardDao;
import kr.or.ddit.board.dao.BoardDaoImpl;
import kr.or.ddit.board.vo.BoardVO;
import kr.or.ddit.util.SqlMapClientUtil;
import util.JDBCUtil;
import util.JDBCUtil3;

public class BoardImpl implements IBoardService{

	//사용할 DAO의 객체변수를 선언한다.
	private IboardDao memDao;
	private SqlMapClient smc;
	
	private static IBoardService service;
	
	private BoardImpl() {
		memDao = BoardDaoImpl.getInstance();
		smc = SqlMapClientUtil.getInstance();
	}
	
	public static IBoardService getInstance() {
		if(service == null) {
			service = new BoardImpl();
		}
		return service;
	}
	@Override
	public int insertMember(BoardVO mv) {
		int cnt = 0;
		
		try {
			cnt = memDao.insertMember(smc, mv);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cnt;
	}

	@Override
	public boolean checkMember(String memId) {
		boolean chk = false;
		
		try {
			chk = memDao.checkMember(smc, memId);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return chk;
	}

	@Override
	public List<BoardVO> getAllMemberList() {
		
		List<BoardVO> memList = new ArrayList<BoardVO>();
		try {
			memList = memDao.getAllMemberList(smc);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return memList;
	}

	@Override
	public int updateMember(BoardVO mv) {
		int cnt = 0;
		try {
			cnt = memDao.updateMember(smc, mv);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cnt;
	}

	@Override
	public int deleteMember(String memId) {
		int cnt = 0;
		try {
			cnt = memDao.deleteMember(smc, memId);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cnt;
	}
	
	@Override
	public List<BoardVO> getSearchMember(BoardVO mv) {
		List<BoardVO> memList = new ArrayList<>();
		
		try {
			memList = memDao.getSearchMember(smc, mv);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return memList;
	}
	
	
}
