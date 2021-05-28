package kr.or.ddit.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.dto.MenuVO;

public interface MenuDAO {
	List<MenuVO> selectMainMenu(SqlSession session) throws SQLException;
	
	List<MenuVO> selectSubMenu(SqlSession session, String mCode) throws SQLException;
	
	MenuVO selectMenuByMcode(SqlSession session, String mCode) throws SQLException;
}
