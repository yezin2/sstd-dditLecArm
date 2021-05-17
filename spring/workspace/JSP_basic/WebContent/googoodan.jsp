<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>

	<h3>
	
	<%
	for(int j=2; j<10; j++){
		
	%>
	<%=j%>단 입니다.&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	<% } %>
	</h3><br/>
	<%
	for(int i=1; i<10; i++){
	%>
		<p>
		<%
		for(int j=2; j<10; j++){
		%>
			<%=j%> * <%=i%> = <%=i*j%>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<%
		}
		%>
		</p>
	<%
	}
%>