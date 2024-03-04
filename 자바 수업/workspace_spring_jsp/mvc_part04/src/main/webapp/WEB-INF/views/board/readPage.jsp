<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ include file="/WEB-INF/views/common/header.jsp"%>
 <h1>READ PAGE</h1>
 <!-- 게시글 정보 key : board -->
 <table border="1">
 	<tr>
 		<td>제목</td>
 		<td>${board.title}</td>
 	</tr>
 	<tr>
 		<td>작성자</td>
 		<td>${board.writer}</td>
 	</tr>
 	<tr>
 		<td>내용</td>
 		<td>
 			${board.content}
 		</td>
 	</tr>
 	<tr>
 		<td>작성시간</td>
 		<td>${board.regdate}</td>
 	</tr>
 </table>
 <hr/>
 <div>
	<input type="button" id="listBtn" value="게시글 목록"/>
	<!-- login된 사용자를 session에 userInfo -->
	<c:if test="${not empty sessionScope.userInfo}">
		<input type="button" id="replyBtn" value="답변글 작성"/>
		<c:if test="${userInfo.uno eq board.uno}">
			<input type="button" id="modifyBtn" value="게시글 수정"/>
			<input type="button" id="deleteBtn" value="게시글 삭제"/>	
		</c:if>
	</c:if>
 </div>
 <form id="readForm">
 	<input type="hidden" name="bno" value="${board.bno}"/>
 </form>
 <script src="http://code.jquery.com/jquery-latest.min.js"></script>
 <script>
 /*
 	let obj = document.getElementById("listBtn");
 	obj = document.querySelector("#listBtn");
 	obj.onclick = function (){};
 */
 	// 게시글 목록 페이지 이동
 	$("#listBtn").click(function(){
 		location.href="${path}/board/listReply";
 	});
 
 	// 답글, 수정, 삭제 요청 페이지 이동
 	let formObj = $("#readForm");
 	
 	// 답변글 작성 요청.
 	$("#replyBtn").click(function(){
 		formObj.attr("action","${path}/board/replyRegister");
 		formObj.submit();	
 	});
 	
 	$("#modifyBtn").click(function(){
 		formObj.attr("action","${path}/board/modify").submit();
 	});
 
 	$("#deleteBtn").click(function(){
 		formObj.attr("action","${path}/board/remove");
 		formObj.attr("method","POST");
 		formObj.submit();
 	});
 	
 </script>
 <%@ include file="/WEB-INF/views/common/footer.jsp"%>
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 