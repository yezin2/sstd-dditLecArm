package kr.or.ddit.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.dao.MenuDAO;
import kr.or.ddit.dto.MenuVO;

public class MockMenuDAO implements MenuDAO {

	@Override
	public List<MenuVO> selectMainMenu(SqlSession session) throws SQLException {
		List<MenuVO> menuList = null;
		
		if(session.getConnection()==null) throw new SQLException();
		
		MenuVO mv = new MenuVO();
		mv.setMname("회원가입");
		
		menuList = new ArrayList<MenuVO>();
		menuList.add(mv);
		
		return menuList;
	}

	@Override
	public List<MenuVO> selectSubMenu(SqlSession session, String mCode) throws SQLException {
		List<MenuVO> menuList = null;
		
		if(session.getConnection()==null) throw new SQLException();
		
		MenuVO mv = new MenuVO();
		mv.setMname("회원가입");
		
		menuList = new ArrayList<MenuVO>();
		menuList.add(mv);
		
		if(!mCode.equals("M010000")) menuList = null;
		
		return menuList;
	}

	@Override
	public MenuVO selectMenuByMcode(SqlSession session, String mCode) throws SQLException {
		MenuVO mv = null;
		
		if(session.getConnection()==null) throw new SQLException();
		
		if(mCode.equals("M010200")) {
			mv = new MenuVO();
			mv.setMname("회원가입");
		}
		return mv;
	}

}
