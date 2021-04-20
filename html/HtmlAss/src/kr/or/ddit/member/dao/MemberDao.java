package kr.or.ddit.member.dao;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.base.dao.BaseDao;
import kr.or.ddit.member.vo.MemberVO;

/**
 * Dao : 쿼리 호출
 */
public class MemberDao extends BaseDao {
	private SqlMapClient smc;
	
	public MemberDao() {
		smc = super.getSqlMapClient();
	}
	
	public MemberVO retrieveMember(String memId) throws SQLException{
		return (MemberVO)smc.queryForObject("member.retrieveMember", memId);
	}
	
	public List<MemberVO> retrieveMemberList(MemberVO memberVO) throws SQLException {
		return smc.queryForList("member.retrieveMemberList", memberVO);
	}
	
	public void createMember(MemberVO memberVO) throws SQLException {
		smc.insert("member.createMember", memberVO);
	}
}
