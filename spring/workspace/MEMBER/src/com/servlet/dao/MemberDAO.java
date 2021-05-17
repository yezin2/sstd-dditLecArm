package com.servlet.dao;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.servlet.dto.MemberVO;

public interface MemberDAO {
	public List<MemberVO> selectMember(SqlMapClient smc) throws SQLException;
	public MemberVO existMemberByid(SqlMapClient smc, String id) throws SQLException;
	public int insertMember(SqlMapClient smc, MemberVO mv) throws SQLException;
	public int updateMember(SqlMapClient smc, MemberVO mv) throws SQLException;
	public int deleteMember(SqlMapClient smc, String memId) throws SQLException;
	
}
