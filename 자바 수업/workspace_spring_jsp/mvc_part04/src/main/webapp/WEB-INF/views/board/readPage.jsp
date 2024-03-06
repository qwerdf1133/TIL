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
 <!-- 첨부파일 목록 추가 -->
 <div>
 	<!-- 게시글 : board, 첨부파일 : board.files -->
 	<c:if test="${!empty board.files}">
	 	<ul class="uploadList">
	 		<c:forEach var="file" items="${board.files}">
	 			<li data-src="${file}">
	 				<c:choose>
	 					<c:when test="${fn:contains(file,'s_')}">
	 						<img src="${path}/displayFile?fileName=${file}"/>
	 						<div>
	 							<a href="${path}/displayFile?fileName=${fn:replace(file,'s_','')}" target="_blank">
	 								${fn:substringAfter(fn:replace(file,'s_',''),'_')}
	 							</a>
	 						</div>
	 					</c:when>
	 					<c:otherwise>
	 						<!-- 일반파일 -->
	 						<img src="${path}/resources/img/file.png" />
	 						<div>
	 							<a href="${path}/displayFile?fileName=${file}">
	 								${fn:substringAfter(file,'_')}
	 							</a>
	 						</div>
	 					</c:otherwise>
	 				</c:choose>
	 			</li>
	 		</c:forEach>	
	 	</ul>
 	</c:if>
 </div>
 <hr style="clear:both;"/>
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
 		// 게시글 삭제전 첨부파일 삭제
 		let isDeleted = confirm("첨부된 파일이 모두 삭제됩니다. 삭제하시겠습니까?");
 		
 		if(isDeleted){
 			// 첨부파일 목록 저장할 Array
 			let arr = [];	
 			
 			$(".uploadList li").each(function(){
 				// arr 배열에 li요소의 data-src 속성값(파일이름) 저장
 				arr.push($(this).attr("data-src"));
 			});
 			
 			console.log(arr);
 			
 			if(arr.length > 0){
 				$.post('${path}/deleteAllfiles',{files : arr}, function(result){
 					alert(result);
 				});
 			}
 			
	 		formObj.attr("action","${path}/board/remove");
	 		formObj.attr("method","POST");
	 		formObj.submit();
 		}
 	});
 	
 </script>
 <%@ include file="/WEB-INF/views/common/footer.jsp"%>
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 