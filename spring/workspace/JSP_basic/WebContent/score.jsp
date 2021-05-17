<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>

<%!
	public int total(int kor, int eng, int math, int sci){
		return kor + eng + math + sci;
	}
%>

<%
	String korParam = request.getParameter("kor");
	String engParam = request.getParameter("eng");
	String mathParam = request.getParameter("math");
	String sciParam = request.getParameter("sci");
	int total = 0;
	try{
		int kor = Integer.parseInt(korParam);
		int eng = Integer.parseInt(engParam);
		int math = Integer.parseInt(mathParam);
		int sci = Integer.parseInt(sciParam);
		
		total = total(kor,eng,math,sci);
	} catch(Exception e) {
		
	}

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
	<script type="text/javascript">
		var avg = <%=total%>/4.0;
		alert("평균은 " + avg + "입니다.");
	</script>

</body>
</html>