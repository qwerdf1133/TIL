<!-- header.jsp -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="path" value="${pageContext.request.contextPath}" scope="page"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MVC project</title>
</head>
<body>
	<br/><hr/>	
	<a href="${path}">HOME</a>
	<a href="${pageContext.request.contextPath}/user/signIn">SIGN IN</a>
	<a href="<c:url value='/user/signUp'/>">SIGN UP</a>
	
	<a href="">글작성</a>
	<a href="">SIGN OUT</a>
	
	<a href="">게시글 보러 가기</a>
	<br/><hr/>





