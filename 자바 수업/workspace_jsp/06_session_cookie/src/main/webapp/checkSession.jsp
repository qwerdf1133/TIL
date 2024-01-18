<%@page import="java.text.SimpleDateFormat"%>
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
	<h1>session check</h1>
	
	<%
		// tomcat server 설정 기본 : 1800 - 30분
		// 프로젝트 설정 600초 - 10분
		
		// 해당 session의 최대 유지 시간을 초단위로 지정
		// session.setMaxInactiveInterval(60);
	
		int max = session.getMaxInactiveInterval();
		out.println("max inactive : " + max + "<br/>");
	
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		// session 객체 생성 시간을 millis로 반환
		long create = session.getCreationTime();
		String time = sdf.format(create);
		out.println("현재 session 생성 시간 : " + time + "<br/>");
		
		// 현재 session으로 돌아온 client의 마지막 요청 시간
		long last = session.getLastAccessedTime();
		time = sdf.format(last);
		out.println("현재 session 마지막 요청 시간 : " + time + "<br/>");
		
		// 해당 session 객체에 등록된 속성 값들 중에
		// name 값이 uid인 속성값을 삭제
		// session.removeAttribute("uid");
		
		// session 무효화
		session.invalidate();
		out.println("session id : " + session.getId()+"<br/>");
		
		
		// 무효화된 session 객체에 값을 변경하거나 추가하게 되면 오류 발생
		// session.setAttribute("SessionID","add session");
	%>
	<a href="index.jsp">메인으로</a>
</body>
</html>