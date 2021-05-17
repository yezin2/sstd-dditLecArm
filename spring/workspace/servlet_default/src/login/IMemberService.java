package login;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

public interface IMemberService {
	/**
	 * log in시에 db에 등록된 회원id와 일치하는지 확인하기 위함
	 * @param id
	 * @return 작업 성공시 1, 작업 실패시 0
	 */
	public int getMemberId(String id);
	/**
	 * log in시에 입력된 회원 id와 db에 등록된 회원pw와 일치하는지 확인하기 위함
	 * @param mv
	 * @return 작업 성공시 1, 작업 실패시 0
	 */
	public int getMemberPw(MemberVO mv);
	/**
	 * 모든 회원의 정보를 조회한다.
	 * @return 작업 성공시 1, 작업 실패시 0
	 */
	public List<MemberVO> getMemberList();
	public int insertMember(MemberVO mv);
	public int updateMember(MemberVO mv);
	public int deleteMember(String id);
}
