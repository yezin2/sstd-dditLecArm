package com.servlet.service;

import java.sql.SQLException;
import java.util.List;

import com.servlet.dto.MemberVO;
import com.servlet.exception.FailedDeleteException;
import com.servlet.exception.FailedInsertException;
import com.servlet.exception.FailedUpdateException;
import com.servlet.exception.SelecteNullpointerException;

public interface MemberService {
	public List<MemberVO> selectMember()throws SQLException, SelecteNullpointerException;
	public MemberVO existMemberByid(String id)throws SQLException, SelecteNullpointerException;
	public int insertMember(MemberVO mv)throws SQLException, FailedInsertException;
	public int updateMember(MemberVO mv)throws SQLException, FailedUpdateException;
	public int deleteMember(String id)throws SQLException, FailedDeleteException;
}
