<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="kr">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<%
	String str ="홍길동";
	System.out.println("오잉");
	
	//한글깨짐 - 인코딩으로 해결
	request.setCharacterEncoding("utf-8");
	String userName = request.getParameter("userName");
	String userAge = request.getParameter("userAge");
%>
<body>
	<p>안녕하신가, '<span id="sUserName"><%=userName %></span>'씨.</p>
	<br>
	<p>올해로 '<span id="sUserAge"><%=userAge %></span>'세 이시군요.</p>
</body>
</html>