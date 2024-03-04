<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ include file="/WEB-INF/views/common/header.jsp"%>
 <h1>signIn.jsp</h1>
 <form action="signInPost" method="POST">
 	<table border=1>
 		<tr>
			<td>아이디</td>
			<td>
				<input type="text" name="uid" placeholder="USER ID" required/>
			</td>	 		
 		</tr>
 		<tr>
 			<td>비밀번호</td>
 			<td>
 				<input type="password" name="upw" placeholder="USER PASS" required/>
 			</td>
 		</tr>
 		<tr>
 			<td colspan="2">
 				<input type="checkbox" name="userCookie" id="userCookie"/>
 				<label for="userCookie">로그인 정보 저장</label>
 			</td>
 		</tr>
 		<tr>
 			<th colspan="2">
 				<input type="submit" value="SIGN IN" />
 				<button type="button" onclick="location.href='signUp';">Sign Up</button>
 			</th>
 		</tr>
 	</table>
 </form>
 <script>
 	const msg = '${message}';
 	if(msg != ''){
 		alert(msg);	
 	}
 </script>
 <%@ include file="/WEB-INF/views/common/footer.jsp"%>
 
 
 
 
 
 
 