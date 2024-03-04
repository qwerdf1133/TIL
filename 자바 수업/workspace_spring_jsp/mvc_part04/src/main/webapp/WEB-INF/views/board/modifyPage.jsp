<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ include file="/WEB-INF/views/common/header.jsp"%>
 <h1>MODIFY BOARD</h1>
 <!-- 수정할 게시글 정보 : board -->
 <form method="POST">
 	 <input type="hidden" name="uno" value="${userInfo.uno}"/>
 	 <input type="hidden" name="bno" value="${board.bno}"/>
	 <table>
	 	<tr>
	 		<td>제목</td>
	 		<td>
	 			<input type="text" name="title" value="${board.title}" required/>
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
	 			<textarea name="content" cols="50" rows="20" required>${board.content}</textarea>
	 		</td>
	 	</tr>
	 	<tr>
	 		<th colspan="2">
	 			<input type="submit" value="게시글 수정 등록"/>
	 		</th>
	 	</tr>
	 </table>	
 </form>
 <%@ include file="/WEB-INF/views/common/footer.jsp"%>
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 