package kr.or.ddit.basic;

import java.io.IOException;
import java.util.Date;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
	서블릿 필터에 대하여...
	
	1. 사용 목적
		- 클라이언트의 요청을 수행하기 전에 가로채 필요한 작업을 수행할 수 있다.
		- 클라이언트에 응답정보를 제공하기 전에 응답정보에 필요한 작업을 수행할 수 있다.
	2. 사용 예시
		- 인증 필터
		- 데이터 압축필터
		- 인코딩 필터
		- 로깅 및 감사처리 필터
		- 이미지 변환 필터 등
 */
public class T07_ServletFilter implements Filter{

	@Override
	public void destroy() {
		// 필터 객체가  웹컨테이너에 의해 서비스로부터 제거되기 전에 호출됨.
		System.out.println("destroy() 호출됨");
		
	}

	@Override
	public void init(FilterConfig fc) throws ServletException {
		System.out.println("init() 메서드 호출됨.");
		// 초기화 파라미터 정보 가져오기
		String initParam = fc.getInitParameter("init-param");
		
		System.out.println("init-param : " + initParam);		
	}
	
	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain fc)
			throws IOException, ServletException {
		System.out.println("T07_ServletFilter 시작.");
		
		// 클라이언트의 IP 주소 가져오기
		String ipAddress = req.getRemoteAddr();
		
		System.out.println("IP주소 : " + ipAddress
						 + "\n포트번호 : " + req.getRemotePort()
						 + "\n현재시간 : " + new Date().toString());
		
		// 필터체인을 실행한다.(req, resp객체 전달)
		fc.doFilter(req, resp);
		
		System.out.println("T07_ServletFilter 완료.");
	}
}
