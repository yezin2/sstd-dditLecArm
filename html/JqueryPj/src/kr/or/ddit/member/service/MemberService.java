package kr.or.ddit.member.service;

import java.sql.SQLException;
import java.util.List;

import kr.or.ddit.member.dao.MemberDao;
import kr.or.ddit.member.vo.MemberVO;

public class MemberService {
	// singleton 패턴 적용
	private MemberDao dao;
	
	public MemberService() {
		if(dao == null)
			dao = new MemberDao();
	}
	
	public MemberVO retrieveMember(String memberId) throws SQLException {
		MemberVO memberVO = dao.retrieveMember(memberId);
		return memberVO;
	}
	
	public List<MemberVO> retrieveMemberList(MemberVO memberVo) throws SQLException {
		List<MemberVO> list = dao.retrieveMemberList(memberVo);
		return list;
	}

	public void createMember(MemberVO memberVO) throws SQLException {
		/* 1. 등록 전 유효성 체크(중복 ID/ ID, PW 유효성 검사)*/
//		MemberVO resultVO = dao.retrieveMember(memberVO.getMemId());
//		if(resultVO != null)
//			return;
		 /* 2. DBd에 insert 하기*/
		dao.createMember(memberVO);
		
	}
	
}
