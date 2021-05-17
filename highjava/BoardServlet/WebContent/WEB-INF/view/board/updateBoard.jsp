<%@page import="java.util.List"%>
<%@page import="kr.or.ddit.board.vo.BoardVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%

	BoardVO bv = (BoardVO)request.getAttribute("bv");
	

%>
<!DOCTYPE html>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>게시글 수정</title>
</head>
<body>
	<form action="updateBoard.do" method="post">
		<input type="hidden" name="boardNo" value="<%=bv.getBoardNo()%>">
		<table>
			<tr>
				<td>제목 : </td>
				<td><input type="text" name="boardTitle" value="<%=bv.getBoardTitle()%>"></td>
			</tr>
			<tr>
				<td>작성자 : </td>
				<td><input type="text" name="boardAuthor" value="<%=bv.getBoardAuthor()%>"></td>
			</tr>
			<tr>
				<td>내용 : </td>
				<td><textarea rows="5" cols="10" name="boardContent"><%=bv.getBoardContent()%></textarea></td>
			</tr>
		</table>
		<input type="submit" value="수정">
	</form>
</body>
</html>