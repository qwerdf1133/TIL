<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- logOut.jsp -->
<%
	session.removeAttribute("loginMember");
	
	// 사용자 pc에 저장된 쿠키 정보 삭제
	Cookie cookie = new Cookie("uid","");
	cookie.setMaxAge(0);
	cookie.setPath("/");
	response.addCookie(cookie);
%>
<script>
	alert('로그아웃 완료');
	location.href='main.jsp';
</script>