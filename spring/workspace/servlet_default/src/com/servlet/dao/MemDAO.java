package com.servlet.dao;

import java.sql.SQLException;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.servlet.dto.MemberVO;

public interface MemDAO {
	public MemberVO selectMemberByID(SqlMapClient smc, String id) 
			throws SQLException;
	
}
