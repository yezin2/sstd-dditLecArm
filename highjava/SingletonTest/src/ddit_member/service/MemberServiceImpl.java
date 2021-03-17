package ddit_member.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ddit_member.dao.IMemberDao;
import ddit_member.dao.MemberDaoImpl;
import ddit_member.vo.MemberVO;
import util.JDBCUtil;
import util.JDBCUtil3;

public class MemberServiceImpl implements IMemberService{

	//사용할 DAO의 객체변수를 선언한다.
	private IMemberDao memDao;
	private Connection conn;
	
	private static IMemberService service;
	
	private MemberServiceImpl() {
		memDao = MemberDaoImpl.getInstance();
	}
	
	public static IMemberService getInstance() {
		if(service == null) {
			service = new MemberServiceImpl();
		}
		return service;
	}
	@Override
	public int insertMember(MemberVO mv) {
		
		int cnt = 0;
		
		try {
			conn = JDBCUtil3.getConnection();
			cnt = memDao.insertMember(conn, mv);
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil3.disConnect(conn, null, null, null);
		}
		return cnt;
	}

	@Override
	public boolean checkMember(String memId) {
		boolean chk = false;
		
		
		try {
			conn = JDBCUtil3.getConnection();
			chk = memDao.checkMember(conn, memId);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil3.disConnect(conn, null, null, null);
		}
		return chk;
	}

	@Override
	public List<MemberVO> getAllMemberList() {
		
		List<MemberVO> memList = new ArrayList<MemberVO>();
		try {
			conn = JDBCUtil.getConnection();
			memList = memDao.getAllMemberList(conn);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil3.disConnect(conn, null, null, null);
		}
		return memList;
	}

	@Override
	public int updateMember(MemberVO mv) {
		int cnt = 0;
		try {
			conn = JDBCUtil.getConnection();
			cnt = memDao.updateMember(conn, mv);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil3.disConnect(conn, null, null, null);
		}
		return cnt;
	}

	@Override
	public int deleteMember(String memId) {
		int cnt = 0;
		try {
			conn = JDBCUtil.getConnection();
			cnt = memDao.deleteMember(conn, memId);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCUtil3.disConnect(conn, null, null, null);
		}
		return cnt;
	}
	
	@Override
	public List<MemberVO> getSearchMember(MemberVO mv) {
		List<MemberVO> memList = new ArrayList<>();
		
		try {
			conn = JDBCUtil.getConnection();
			memList = memDao.getSearchMember(conn, mv);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.disConnect(conn, null, null, null);
		}
		return memList;
	}
	
	
}
