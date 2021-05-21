package kr.or.ddit.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.dto.MemberVO;

public class MemberDAOImpl implements MemberDAO{
	
	@Override
	public List<MemberVO> selectMember(SqlSession session) throws SQLException {
		List<MemberVO> memList = session.selectList("member.selectMember");
		return memList;
	}

	@Override
	public MemberVO existMemberByid(SqlSession session, String id) throws SQLException {
		MemberVO mv = session.selectOne("member.existMemberByid", id);
		return mv;
	}
	
	@Override
	public int insertMember(SqlSession session, MemberVO mv) throws SQLException {
		int cnt = 0;
		Object obj = session.insert("member.insertMember", mv);
		if(obj != null) {
			cnt = 1;
		}
		return cnt;
	}

	@Override
	public int updateMember(SqlSession session, MemberVO mv) throws SQLException {
		int cnt = session.update("member.updateMember", mv);
		return cnt;
	}

	@Override
	public int deleteMember(SqlSession session, String memId) throws SQLException {
		int cnt = session.delete("member.deleteMember", memId);
		return cnt;
	}
}
