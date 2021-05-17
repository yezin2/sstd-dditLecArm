package com.servlet.service;

import java.sql.SQLException;

import com.servlet.dto.MemberVO;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.servlet.dao.MemDAO;
import com.servlet.exception.InvalidPasswordException;
import com.servlet.exception.NotFoundIDException;

public class MemberServiceImpl implements MemberService {

	private MemDAO memberDAO; // - MemberDAOImpl.getInstance();
	private SqlMapClient smc;
	@Override
	public MemberVO login(String id, String pwd) throws NotFoundIDException, InvalidPasswordException, SQLException {
		MemberVO member = null;
		
		try {
			member = memberDAO.selectMemberByID(smc,id);
		} catch (SQLException e) {
			// Exception에 대한 처리 구문 필요
			e.printStackTrace();
			throw e;
		}
		if(member != null) {
			if(pwd.equals(member.getPw())) {//로그인 성공
				return member;
			} else { //패스워드 불일치
				throw new InvalidPasswordException();
			}
		} else {
			throw new NotFoundIDException();
		}
	}

}
