package kr.or.ddit.util;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

public class HttpServletRequestWrapperTest extends HttpServletRequestWrapper{

	public HttpServletRequestWrapperTest(HttpServletRequest request) {
		// 기본 리퀘스트 객체를 파라미터로 꼭 넣어줘야함
		super(request);
		// 첨부파일을 하기 위해 multipart로 파일 인코딩 방식이 달라졌기 때문에 파라미터가 null로 다 날라감
		// 첨부파일이 있으면 multipart방식으로 보내고 없으면 기존 방식으로 보내기 위해 wrapper를 사용함
	}

}
