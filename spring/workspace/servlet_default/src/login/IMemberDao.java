package login;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

public interface IMemberDao {
	/**
	 * log in시에 db에 등록된 회원id와 일치하는지 확인하기 위함
	 * @param id 
	 * @param password
	 * @return 작업 성공시 1, 작업 실패시 0
	 * @throws SQLException
	 */
	public int getMemberId(SqlMapClient smc, String id) throws SQLException;
	/**
	 * log in시에 입력된 회원 id와 db에 등록된 회원pw와 일치하는지 확인하기 위함
	 * @param mv
	 * @param password
	 * @return 작업 성공시 1, 작업 실패시 0
	 * @throws SQLException
	 */
	public int getMemberPw(SqlMapClient smc, MemberVO mv) throws SQLException;
	/**
	 * 모든 회원의 정보를 조회한다.
	 * @return 조회된 모든 회원 정보
	 * @throws SQLException
	 */
	public List<MemberVO> getMemberList(SqlMapClient smc) throws SQLException;
	/**
	 * 회원 등록
	 * @param mv 등록할 회원의 정보
	 * @return 작업 성공시 1, 작업 실패시 0
	 * @throws SQLException
	 */
	public int insertMember(SqlMapClient smc, MemberVO mv) throws SQLException;
	/**
	 * 회원 수정
	 * @param mv 수정할 회원의 정보
	 * @return 작업 성공시 1, 작업 실패시 0
	 * @throws SQLException
	 */
	public int updateMember(SqlMapClient smc, MemberVO mv) throws SQLException;
	/**
	 * 회원 삭제
	 * @param id 삭제할 회원의 id
	 * @return 작업 성공시 1, 작업 실패시 0
	 * @throws SQLException
	 */
	public int deleteMember(SqlMapClient smc, String id) throws SQLException;
}
