<%@page import="kr.or.ddit.board.vo.BoardVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript" src="/BoardServlet/jquery-3.6.0.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Servlet Board</title>
<style type="text/css">
	
</style>
</head>
<body>
	<form action="insertBoard.do" method="post">
		제목 : <input type="text" name="boardTitle"><br><br>
		작성자 : <input type="text" name="boardAuthor"><br><br>
		내용 : <input type="text" name="boardContent"><br><br>
		첨부파일 : <input type="file" name="atchFile"><br><br><br><br>
		<button type="submit">등록</button>
	</form><br><br><br><br>
</body>
</html>