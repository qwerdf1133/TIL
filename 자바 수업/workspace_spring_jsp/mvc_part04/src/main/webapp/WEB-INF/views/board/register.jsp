<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ include file="/WEB-INF/views/common/header.jsp"%>
 <h1>register.jsp</h1>
 <!--
 	action이 생략되면 연재 주소표시줄의 요청 경로로 요청 전달 
 	board/register 
-->
 <form method="POST">
 	 <input type="hidden" name="uno" value="${userInfo.uno}"/>
	 <table>
	 	<tr>
	 		<td>제목</td>
	 		<td>
	 			<input type="text" name="title" required/>
	 		</td>
	 	</tr>
	 	<tr>
	 		<td>작성자</td>
	 		<td>
	 			<input type="text" name="writer" value="${userInfo.uname}" readonly/>
	 		</td>
	 	</tr>
	 	<tr>
	 		<td>내용</td>
	 		<td>
	 			<textarea name="content" cols="50" rows="20" required></textarea>
	 		</td>
	 	</tr>
	 	<tr>
	 		<th colspan="2">
	 			<input type="submit" value="게시글 등록"/>
	 		</th>
	 	</tr>
	 </table>	
 </form>
 <%@ include file="/WEB-INF/views/common/footer.jsp"%>
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 