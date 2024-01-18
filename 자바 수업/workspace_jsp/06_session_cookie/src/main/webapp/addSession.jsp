<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%@ include file="check.jsp" %>
	<h1>addSession.jsp</h1>
	<%
		if(session.getAttribute("uid") == null){
			session.setAttribute("uid", "hap0p9y");
		}
	%>
	<a href="checkSession.jsp">checkSession</a>
</body>
</html>