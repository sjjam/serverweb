<%@page import="member.MemberDTO"%>
<%@page import="java.util.ArrayList"%>
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
		ArrayList<MemberDTO> list = (ArrayList<MemberDTO>)request.getAttribute("list");
	%>
	
		<h1>�μ���Ϻ���</h1>
	 	<hr/>
		<table border='1' width='500'>
		<tr>
		<th>�μ� �ڵ�</th><th>����</th><th>���</th>
		<th>�н�����</th><th>�ּ�</th><th>����Ʈ</th><th>���</th><th>����</th>
		<%
		int size = list.size();
		for(int i=0;i<size;i++) {
			MemberDTO mem = list.get(i);%>
			<tr>
				<td><%=mem.getDeptno()%></td>
				<td><%=mem.getName()%></td>
				<td><a href="/serverweb/member/read.do?id=<%=mem.getId()%>"><%=mem.getId()%></a></td>
				<td><%=mem.getPass()%></td>
				<td><%=mem.getAddr()%></td>
				<td><%=mem.getPoint()%></td>
				<td><%=mem.getGrade()%></td>
				<td><a href="/serverweb/member/delete.do?id=<%= mem.getId()
						%>">����</a></td>
			</tr>
		<%} %>
		</table>
		
</body>
</html>