package kr.or.ddit.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.dto.MemberVO;

public interface MemberDAO {
	public List<MemberVO> selectMember(SqlSession session) throws SQLException;
	public MemberVO existMemberByid(SqlSession session, String id) throws SQLException;
	public int insertMember(SqlSession session, MemberVO mv) throws SQLException;
	public int updateMember(SqlSession session, MemberVO mv) throws SQLException;
	public int deleteMember(SqlSession session, String memId) throws SQLException;
	
}
