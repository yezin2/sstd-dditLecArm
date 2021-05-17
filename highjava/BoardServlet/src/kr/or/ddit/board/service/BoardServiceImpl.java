package kr.or.ddit.board.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.board.dao.IBoardDao;
import kr.or.ddit.board.dao.BoardDaoImpl;
import kr.or.ddit.board.vo.BoardVO;
import kr.or.ddit.util.SqlMapClientUtil;
import util.JDBCUtil;
import util.JDBCUtil3;

public class BoardServiceImpl implements IBoardService{

	//사용할 DAO의 객체변수를 선언한다.
	private IBoardDao memDao;
	private SqlMapClient smc;
	
	private static IBoardService service;
	
	private BoardServiceImpl() {
		memDao = BoardDaoImpl.getInstance();
		smc = SqlMapClientUtil.getInstance();
	}
	
	public static IBoardService getInstance() {
		if(service == null) {
			service = new BoardServiceImpl();
		}
		return service;
	}
	@Override
	public int insertBoard(BoardVO bv) {
		int cnt = 0;
		
		try {
			cnt = memDao.insertBoard(smc, bv);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cnt;
	}

	@Override
	public BoardVO existBoardByboardNo(String boardNo) {
		BoardVO bv = null;
		
		try {
			bv = memDao.existBoardByboardNo(smc, boardNo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return bv;
	}

	@Override
	public List<BoardVO> selectAllBoard() {
		
		List<BoardVO> memList = new ArrayList<BoardVO>();
		try {
			memList = memDao.selectAllBoard(smc);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return memList;
	}

	@Override
	public int updateBoard(BoardVO bv) {
		int cnt = 0;
		try {
			cnt = memDao.updateBoard(smc, bv);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cnt;
	}

	@Override
	public int deleteBoard(String boardNo) {
		int cnt = 0;
		try {
			cnt = memDao.deleteBoard(smc, boardNo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cnt;
	}
	
	@Override
	public List<BoardVO> selectBoardbyVO(BoardVO mv) {
		List<BoardVO> memList = new ArrayList<>();
		
		try {
			memList = memDao.selectBoardbyVO(smc, mv);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return memList;
	}
	
	
}
