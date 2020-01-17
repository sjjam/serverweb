<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<table border="1">
	<%for(int i=0;i<=10;i++){%>
			<tr>
				<td width="30px" align="center"><%= i %></td>
			</tr>
		</table>
		<%} %>
</body>
</html>