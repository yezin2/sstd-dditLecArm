<%@page import="kr.or.ddit.member.vo.MemberVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
[
<% 
//서블릿에서 조회 결과를 "list"라는 key로 request에 담아줫음
List<MemberVO> list = (List<MemberVO>)request.getAttribute("list");

for(int i=0; i<list.size(); i++){
	MemberVO mv = list.get(i);
	String memId = mv.getMemId();
	String memName = mv.getMemName();
	String memBir = mv.getMemBir();
	String memHp = mv.getMemHp();
	String memAdd1 = mv.getMemAdd1();
	String memMail = mv.getMemMail();
	String memJob = mv.getMemJob();
	String memJobName = mv.getMemJobName();
	int memMileage = mv.getMemMileage();
	
	//json타입으로 만들어야 하는 부분 >> {name : "~", id : "~"}

	if(i>0) {
		%>,<%
	}
	%>
	{"memName" : "<%=memName %>", 
	"memId" : "<%=memId %>",
	"memBir" : "<%=memBir %>",
	"memHp" : "<%=memHp %>",
	"memAddr" : "<%=memAdd1 %>",
	"memMail" : "<%=memMail %>",
	"memJob" : "<%=memJob %>",
	"memJobName" : "<%=memJobName %>",
	"memMileage" : "<%=memMileage %>"}
	<%
}
%>
]