package kr.or.ddit.service;

import java.sql.SQLException;
import java.util.List;

import kr.or.ddit.dto.MemberVO;
import kr.or.ddit.exception.FailedDeleteException;
import kr.or.ddit.exception.FailedInsertException;
import kr.or.ddit.exception.FailedUpdateException;
import kr.or.ddit.exception.SelecteNullpointerException;

public interface MemberService {
	public List<MemberVO> selectMember()throws SQLException, SelecteNullpointerException;
	public MemberVO existMemberByid(String id)throws SQLException, SelecteNullpointerException;
	public int insertMember(MemberVO mv)throws SQLException, FailedInsertException;
	public int updateMember(MemberVO mv)throws SQLException, FailedUpdateException;
	public int deleteMember(String id)throws SQLException, FailedDeleteException;
}
