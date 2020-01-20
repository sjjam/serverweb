<%@page import="java.util.ArrayList"%>
<%@page import="dept.DeptDTO"%>
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
		//서블릿 공유해준 ArrayList<DeptDTO>객체 가져오기
		ArrayList<DeptDTO> list = (ArrayList<DeptDTO>)request.getAttribute("list");
	%>
	
		<h1>부서목록보기</h1>
	 	<hr/>
		<table border='1' width='500'>
		<tr>
		<th>부서 번호</th><th>부서 이름</th><th>부서 위치</th>
		<th>전화 번호</th><th>담당자</th><th>삭제</th>
		<%
		int size = list.size();
		for(int i=0;i<size;i++) {
			DeptDTO dept = list.get(i);%>
			<tr>
				<td><%=dept.getDeptNo()%></td>
				<td><a href="/serverweb/dept/read.do?deptNo=<%=dept.getDeptNo()%>&info=한글데이터"><%=dept.getDeptName()%></a></td>
				<td><%=dept.getLoc()%></td>
				<td><%=dept.getTel()%></td>
				<td><%=dept.getMgr()%></td>
				<td><a href="/serverweb/dept/delete.do?deptNo=<%= dept.getDeptNo()
						%>">삭제</a></td>
			</tr>
		<%} %>
		</table>
		
</body>
</html>