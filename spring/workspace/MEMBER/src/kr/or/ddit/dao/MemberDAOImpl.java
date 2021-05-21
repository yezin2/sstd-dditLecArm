package kr.or.ddit.dao;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.dto.MemberVO;

public class MemberDAOImpl implements MemberDAO{
	
	private static MemberDAO memberDAO;
		
		private MemberDAOImpl() { }
		public static MemberDAO getInstance() {
			if(memberDAO == null) {
				memberDAO = new MemberDAOImpl();
			}
			return memberDAO;
		}

	@Override
	public List<MemberVO> selectMember(SqlMapClient smc) throws SQLException {
		List<MemberVO> memList = smc.queryForList("member.selectMember");
		return memList;
	}

	@Override
	public MemberVO existMemberByid(SqlMapClient smc, String id) throws SQLException {
		MemberVO mv = (MemberVO) smc.queryForObject("member.existMemberByid", id);
		return mv;
	}
	
	@Override
	public int insertMember(SqlMapClient smc, MemberVO mv) throws SQLException {
		int cnt = 0;
		Object obj = smc.insert("member.insertMember", mv);
		if(obj == null) {
			cnt = 1;
		}
		return cnt;
	}

	@Override
	public int updateMember(SqlMapClient smc, MemberVO mv) throws SQLException {
		int cnt = smc.update("member.updateMember", mv);
		return cnt;
	}

	@Override
	public int deleteMember(SqlMapClient smc, String memId) throws SQLException {
		int cnt = smc.delete("member.deleteMember", memId);
		return cnt;
	}
}
