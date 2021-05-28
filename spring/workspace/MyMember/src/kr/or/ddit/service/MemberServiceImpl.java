package kr.or.ddit.service;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import kr.or.ddit.dao.MemberDAO;
import kr.or.ddit.dao.MemberDAOImpl;
import kr.or.ddit.dto.MemberVO;
import kr.or.ddit.exception.FailedDeleteException;
import kr.or.ddit.exception.FailedInsertException;
import kr.or.ddit.exception.FailedUpdateException;
import kr.or.ddit.exception.SelecteNullpointerException;
import kr.or.ddit.mybatis.OracleMyBatisSqlSessionFactory;

public class MemberServiceImpl implements MemberService {

	private MemberDAO memberDAO = new MemberDAOImpl(); // - MemberDAOImpl.getInstance();
	public void setMemberDAO(MemberDAO memberDAO) {
		this.memberDAO = memberDAO;
	}
	
	private SqlSessionFactory sqlSessionFactory = new OracleMyBatisSqlSessionFactory();
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		this.sqlSessionFactory = sqlSessionFactory;
	}
	
	@Override
	public List<MemberVO> selectMember() throws SQLException, SelecteNullpointerException{
		List<MemberVO> memberList = null;
		
		SqlSession session = sqlSessionFactory.openSession(false);
		try {
			memberList = memberDAO.selectMember(session);
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} 
		session.close();
		
		if(memberList != null) 
			return memberList;
		else 
			throw new SelecteNullpointerException();
	}
	
	@Override
	public MemberVO existMemberByid(String id) throws SQLException, SelecteNullpointerException {
		MemberVO mv = null;
		
		SqlSession session = sqlSessionFactory.openSession(false);
		try {
			mv = memberDAO.existMemberByid(session, id);
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		}
		session.close();
		
		if(mv != null) {
			return mv;
		} else {
			throw new SelecteNullpointerException(); 
		}
	}
	
	@Override
	public int insertMember(MemberVO mv) throws SQLException, FailedInsertException{
		int insertResult = 0;
		
		SqlSession session = sqlSessionFactory.openSession(false);
		try {
			insertResult = memberDAO.insertMember(session, mv);
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		}
		session.close();
		
		if(insertResult > 0) {
			return insertResult;
		} else {
			throw new FailedInsertException();
		}
	}
	@Override
	public int updateMember(MemberVO mv) throws SQLException, FailedUpdateException{
		int updateResult = 0;
		
		SqlSession session = sqlSessionFactory.openSession(false);
		try {
			updateResult = memberDAO.updateMember(session, mv);
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		}
		session.close();
		
		if(updateResult > 0) {
			return updateResult;
		} else {
			throw new FailedUpdateException();
		}
	}
	@Override
	public int deleteMember(String memId) throws SQLException, FailedDeleteException{
		int deleteResult = 0;
		
		SqlSession session = sqlSessionFactory.openSession(false);
		try {
			deleteResult = memberDAO.deleteMember(session, memId);
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		}
		session.close();
		
		if(deleteResult > 0) {
			return deleteResult;
		} else {
			throw new FailedDeleteException(); 
		}
	}


	

}
