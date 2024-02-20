<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<c:set var="path" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>uploadResult.jsp</title>
</head>
<body>
	<h1>Upload 결과 확인</h1>
	<h3>${savedName}</h3>
	
	<hr/>
	<h1>multiple</h1>
	<h3>saves</h3>
	<h3>auth : ${auth}</h3>
	<h3>content : ${content}</h3>
	<c:forEach var="f" items="${saves}">
		<h4>saves : ${f}</h4>
		<!-- d882cdf06d35459682481dff8f9e81a5_cat1.jpg -->
		<h4>원본 파일 이름 : ${fn:substringAfter(f,"_")}</h4>
		<h4><a href="${path}/upload/${f}" download="${fn:substringAfter(f,'_')}" target="_blank">${fn:substringAfter(f,"_")}</a></h4>
	</c:forEach>
	
</body>
</html>















