package kr.or.ddit.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import kr.or.ddit.dto.MemberVO;
import kr.or.ddit.mybatis.OracleMyBatisSqlSessionFactory;

public class TestMemberDAOImpl {
	private SqlSession session;
	private MemberDAO memberDAO;
	
	@Before
	public void init() {
		session = new OracleMyBatisSqlSessionFactory().openSession(false);
		memberDAO = new MemberDAOImpl();
	}
	
	@Test
	public void testSelectMember() throws SQLException{
		List<MemberVO> memberList = memberDAO.selectMember(session);
		Assert.assertEquals(5, memberList.size());
	}
	
	@Test
	public void testExistMemberById() throws SQLException{
		MemberVO mv = memberDAO.existMemberByid(session, "test");
		Assert.assertEquals("김이현", mv.getName());
	}
}
