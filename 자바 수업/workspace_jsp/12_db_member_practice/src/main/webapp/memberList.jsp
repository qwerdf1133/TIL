<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<!-- memberList.jsp -->
<%@ include file="common/header.jsp" %>
<section>
<table border=1 class="list">
	<tr>
		<th colspan="7"><h1>회원목록</h1></th>
	</tr>
	<tr>
		<th>번호</th>
		<th>아이디</th>
		<th>이름</th>
		<th>주소</th>
		<th>전화번호</th>
		<th>성별</th>
		<th>나이</th>
	</tr>
	<!-- 회원 목록 출력 -->
	
	<!-- 등록된 회원이 없을 시 출력 -->
	<tr><th colspan="7">등록된 회원이 없습니다.</th></tr>
</table>
</section>
<%@ include file="common/footer.jsp" %>











