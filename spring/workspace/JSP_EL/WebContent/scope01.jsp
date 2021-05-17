<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>

<%
	pageContext.setAttribute("msg", "SO SLEEPY!!");
	request.setAttribute("msg", "I WILL SLEEP!!");
	session.setAttribute("msg", "BUT I HAVE TO STUDY!");
	application.setAttribute("msg", "NO I DO NOT STUDY, I'LL SLEEP!!");
%>
<h1>${param.msg }</h1>￦${value}