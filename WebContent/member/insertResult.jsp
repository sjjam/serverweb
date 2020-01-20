<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<%
		//서블릿이 공유한 데이터 꺼내오기
		int result = (Integer)request.getAttribute("insert");
	%>
	<h1>응답페이지</h1>
	<hr/>
	<h2><%=result %>삽입성공!!!</h2>
</body>
</html>