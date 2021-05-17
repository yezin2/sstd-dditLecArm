<%@page import="kr.or.ddit.board.vo.BoardVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%
   		List<BoardVO> boardList = (List<BoardVO>)request.getAttribute("boardList");
   %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript" src="<%=request.getContextPath() %>/jquery-3.6.0.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Servlet Board</title>
<style type="text/css">
	table, th, td {
		border: 5px solid black;
		border-collapse: collapse;
	}
</style>
</head>
<body>
	<table style="border: 1px solid black;">
		<caption>
			서블릿을 이용한 게시판
		</caption>
		<thead>
			<tr>
				<th>번호</th>
				<th>제목</th>
				<th>작성자</th>
				<th>내용</th>
				<th>작성일</th>
				<th>관리</th>
			</tr>
		</thead>
		<tbody>
		<% 
			for(int i=0; i<boardList.size(); i++){
		%>
			<tr>
				<td><%=boardList.get(i).getBoardNo() %></td>
				<td><%=boardList.get(i).getBoardTitle() %></td>
				<td><%=boardList.get(i).getBoardAuthor() %></td>
				<td><%=boardList.get(i).getBoardContent() %></td>
				<td><%=boardList.get(i).getBoardDate() %></td>
				<td>
					<button type="button" onclick="fnUpdate(<%=boardList.get(i).getBoardNo() %>)">수정</button>
					<button type="button" onclick="fnDelete(<%=boardList.get(i).getBoardNo() %>)">삭제</button>
				</td>
			</tr>
		<% 
			}
		%>
		</tbody>
	</table>
	<button type="button" onclick="fnInsert()">등록</button>
</body>
<script type="text/javascript">
	function fnInsert() {
		location.href = "<%=request.getContextPath()%>/insertBoard.do";
	}
	function fnUpdate(boardNo) {
		location.href = "<%=request.getContextPath()%>/updateBoard.do?boardNo=" + boardNo;
	}
	function fnDelete(boardNo) {
		location.href = "<%=request.getContextPath()%>/deleteBoard.do?boardNo=" + boardNo;
	}
</script>
</html>