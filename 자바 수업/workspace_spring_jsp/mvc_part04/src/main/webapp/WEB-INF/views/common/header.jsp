<!-- header.jsp -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<c:set var="path" value="${pageContext.request.contextPath}" scope="page"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MVC project</title>
<link rel="stylesheet" href="${path}/resources/css/file.css"/>
</head>
<body>
	<br/><hr/>	
	<a href="${path}">HOME</a>
	<c:choose>
		<c:when test="${empty sessionScope.userInfo}">
			<a href="${pageContext.request.contextPath}/user/signIn">SIGN IN</a>
			<a href="<c:url value='/user/signUp'/>">SIGN UP</a>
		</c:when>
		<c:otherwise>
			<span>&nbsp;&nbsp;${userInfo.uname}&nbsp;&nbsp;</span>
			<a href="${path}/user/signOut">SIGN OUT</a>
			<a href="${path}/board/register">글작성</a>
		</c:otherwise>
	</c:choose>
	<a href="${path}/board/listReply">게시글 보러 가기</a>
	<br/><hr/>










