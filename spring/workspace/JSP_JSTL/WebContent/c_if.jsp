<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<% 
	int k=5;
	pageContext.setAttribute("k", k);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
	<%
		if(k>3){
			out.print("잘한다.");
		}
	%>
	<c:if test="${k>3 }">
		짜란다!
	</c:if>
</body>
</html>