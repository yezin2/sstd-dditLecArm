package kr.or.ddit.controller;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

public class JSONResolver {
	public static void view(HttpServletResponse response, Object target) throws Exception{
		//출력
		ObjectMapper mapper = new ObjectMapper();
		
		//content type 결정
		response.setContentType("application/json;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		//내보내기
		out.println(mapper.writeValueAsString(target));
		
		//out 샛체를 종료하고 환원
		out.close();
	}
}
