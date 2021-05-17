package login;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import util.SqlMapClientUtil;

public class MemberServiceImpl implements IMemberService{
	
	private IMemberDao memdao;
	private SqlMapClient smc;
	
	private static IMemberService service;
	
	private MemberServiceImpl() {//여기서부터
		memdao = MemberDaoImpl.getInstance();
		smc = SqlMapClientUtil.getInstance();
	}

	public static IMemberService getInstance() {
		if(service == null) {
			service = new MemberServiceImpl();
		}
		return service;
	}//여기까지 왜 이렇게 쓰는지 모름
	@Override
	public int getMemberId(String id) {
		int cnt = 0;
		
		try {
			cnt = memdao.getMemberId(smc, id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cnt;
	}

	@Override
	public int getMemberPw(MemberVO mv) {
		int cnt = 0;
		
		try {
			cnt = memdao.getMemberPw(smc, mv);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cnt;
	}

	@Override
	public List<MemberVO> getMemberList() {
		List<MemberVO> memList = new ArrayList<MemberVO>();
		
		try {
			memList = memdao.getMemberList(smc);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public int insertMember(MemberVO mv) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateMember(MemberVO mv) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteMember(String id) {
		// TODO Auto-generated method stub
		return 0;
	}

}
