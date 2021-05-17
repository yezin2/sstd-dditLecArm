package com.servlet.service;

import java.sql.SQLException;
import java.util.List;

import com.servlet.dto.MemberVO;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.servlet.dao.MemberDAO;
import com.servlet.dao.MemberDAOImpl;
import com.servlet.exception.FailedDeleteException;
import com.servlet.exception.FailedInsertException;
import com.servlet.exception.FailedUpdateException;
import com.servlet.exception.SelecteNullpointerException;
import com.servlet.util.SqlMapClientUtil;

public class MemberServiceImpl implements MemberService {

	private MemberDAO memberDAO; // - MemberDAOImpl.getInstance();
	private SqlMapClient smc;
	private static MemberService service;
	
	private MemberServiceImpl() {
		memberDAO = MemberDAOImpl.getInstance();
		smc = SqlMapClientUtil.getInstance();
		
	}
	
	public static MemberService getInstance() {
		if(service == null) {
			service = new MemberServiceImpl();
		}
		return service;
	}
	@Override
	public List<MemberVO> selectMember() throws SQLException, SelecteNullpointerException{
		List<MemberVO> memList = null;
		try {
			memList = memberDAO.selectMember(smc);
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		}
		if(memList != null) {
			return memList;
		} else {
			throw new SelecteNullpointerException();
		}
	}
	@Override
	public int insertMember(MemberVO mv) throws SQLException, FailedInsertException{
		int insertResult = 0;
		try {
			insertResult = memberDAO.insertMember(smc, mv);
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		}
		if(insertResult > 0) {
			return insertResult;
		} else {
			throw new FailedInsertException();
		}
	}
	@Override
	public int updateMember(MemberVO mv) throws SQLException, FailedUpdateException{
		int updateResult = 0;
		try {
			updateResult = memberDAO.updateMember(smc, mv);
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		}
		if(updateResult > 0) {
			return updateResult;
		} else {
			throw new FailedUpdateException();
		}
	}
	@Override
	public int deleteMember(String memId) throws SQLException, FailedDeleteException{
		int deleteResult = 0;
		try {
			deleteResult = memberDAO.deleteMember(smc, memId);
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		}
		if(deleteResult > 0) {
			return deleteResult;
		} else {
			throw new FailedDeleteException(); 
		}
	}

	@Override
	public MemberVO existMemberByid(String id) throws SQLException, SelecteNullpointerException {
		MemberVO mv = null;
		try {
			mv = memberDAO.existMemberByid(smc, id);
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		}
		if(mv != null) {
			return mv;
		} else {
			throw new SelecteNullpointerException(); 
		}
	}

	

}
