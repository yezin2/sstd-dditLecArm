package kr.or.ddit.common.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.common.service.ZipService;
import kr.or.ddit.common.vo.ZipVO;


@WebServlet("/ZipServlet")
public class ZipServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doGet(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//그룹코드로 코드테이블 조회
		try {
			ZipService zipService = new ZipService();
			List<ZipVO> list = new ArrayList<ZipVO>();
			String flag = req.getParameter("flag");

			if("SI".equals(flag)) {
				list = zipService.retrieveSidoList();
			} else if("GU".equals(flag)){
				ZipVO zipVO = new ZipVO();
				zipVO.setSido(req.getParameter("sido"));
				list = zipService.retrieveGugunList(zipVO);
			} else if("DONG".equals(flag)) {
				ZipVO zipVO = new ZipVO();
				zipVO.setSido(req.getParameter("sido"));
				zipVO.setGugun(req.getParameter("gugun"));
				list = zipService.retrieveDongList(zipVO);
			} else {
				ZipVO zipVO = new ZipVO();
				zipVO.setSido(req.getParameter("sido"));
				zipVO.setGugun(req.getParameter("gugun"));
				zipVO.setDong(req.getParameter("dong"));
				list = zipService.retrieveZipList(zipVO);
			}
			
			req.setAttribute("list", list);
			
			RequestDispatcher disp = req.getRequestDispatcher("/html/common/ZipListResult.jsp");
			disp.forward(req, resp);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
