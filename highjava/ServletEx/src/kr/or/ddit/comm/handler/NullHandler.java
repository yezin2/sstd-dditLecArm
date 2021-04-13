package kr.or.ddit.comm.handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 해당요청을 처리할 핸들러를 발견하지 못한경우 호출됨.
 * @author PC-17
 *
 */
public class NullHandler implements CommandHandler{

	@Override
	public boolean isRedirect(HttpServletRequest req) {
		return false;
	}

	@Override
	public String process(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		resp.sendError(HttpServletResponse.SC_NOT_FOUND);
		
		return null;
	}

}
