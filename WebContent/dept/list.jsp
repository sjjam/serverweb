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
		//������ �������� ArrayList<DeptDTO>��ü ��������
		ArrayList<DeptDTO> list = (ArrayList<DeptDTO>)request.getAttribute("list");
	%>
	
		<h1>�μ���Ϻ���</h1>
	 	<hr/>
		<table border='1' width='500'>
		<tr>
		<th>�μ� ��ȣ</th><th>�μ� �̸�</th><th>�μ� ��ġ</th>
		<th>��ȭ ��ȣ</th><th>�����</th><th>����</th>
		<%
		int size = list.size();
		for(int i=0;i<size;i++) {
			DeptDTO dept = list.get(i);%>
			<tr>
				<td><%=dept.getDeptNo()%></td>
				<td><%=dept.getDeptName()%></td>
				<td><%=dept.getLoc()%></td>
				<td><%=dept.getTel()%></td>
				<td><%=dept.getMgr()%></td>
				<td><a href='/serverweb/dept/delete.do?deptNo=<%= dept.getDeptNo()
						%>'>����</a></td>
			</tr>
		<%} %>
		</table>
		
</body>
</html>