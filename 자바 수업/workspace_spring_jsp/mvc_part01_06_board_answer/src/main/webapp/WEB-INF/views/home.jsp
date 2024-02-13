<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>home.jsp</title>
</head>
<body>
	<h2>model msg : ${msg}</h2>
	<a href="<c:url value='/board/register'/>">글쓰기</a> <br/>
	<a href="<c:url value='/board/listPage'/>">paging 글 목록</a>
</body>
</html>





