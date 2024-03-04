<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ include file="/WEB-INF/views/common/header.jsp"%>
 <h1>Reply Register</h1>
 <form action="replyRegister" method="POST">
 	 <input type="hidden" name="uno" value="${userInfo.uno}"/>
 	 <input type="hidden" name="origin" value="${origin.origin}"/>
 	 <input type="hidden" name="depth" value="${origin.depth}"/>
 	 <input type="hidden" name="seq" value="${origin.seq}"/>
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
	 			<input type="submit" value="답변글 등록"/>
	 		</th>
	 	</tr>
	 </table>	
 </form>
 <%@ include file="/WEB-INF/views/common/footer.jsp"%>
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 