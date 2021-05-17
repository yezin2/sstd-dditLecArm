package login;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

public class MemberDaoImpl implements IMemberDao{
	
	private static IMemberDao memdao;
	
	private MemberDaoImpl() {}
	public static IMemberDao getInstance() {//member dao를 왜 생성하는지 모르겟음
		if(memdao == null) {
			memdao = new MemberDaoImpl();
		}
		return memdao;
	}

	@Override
	public int getMemberId (SqlMapClient smc, String id) throws SQLException {
		int cntid = (int) smc.queryForObject("login.getMemberId", id);
		return cntid;
	}
	
	@Override
	public int getMemberPw(SqlMapClient smc, MemberVO mv) throws SQLException {
		int cntpw = (int)smc.queryForObject("login.getMemberPw", mv);
		return cntpw;
	}

	@Override
	public List<MemberVO> getMemberList(SqlMapClient smc) throws SQLException {
		List<MemberVO> memList = (List<MemberVO>) smc.queryForList("getMemberList");
		return memList;
	}

	@Override
	public int insertMember(SqlMapClient smc, MemberVO mv) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateMember(SqlMapClient smc, MemberVO mv) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteMember(SqlMapClient smc, String id) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}
}
