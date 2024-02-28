<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <!-- WEB-INF/views/user/signUp.jsp -->
<%@ include file="/WEB-INF/views/common/header.jsp"%>
<h1>Sign Up</h1>
<form action="signUpPost" method="POST">
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
			<td>비밀번호 확인</td>
			<td>
				<input type="password" name="rePw" placeholder="RE PASS" required/>
			</td>	
		</tr>
		<tr>
			<td>사용자 이름</td>
			<td>
				<input type="text" name="uname" placeholder="USER NAME" required/>
			</td>
		</tr>
		<tr>
			<td colspan="2">
				<input type="submit" value="Sign Up"/>
				<input type="button" onclick="location.href='signIn';" value="Sign In">
			</td>
		</tr>
	</table>
</form>
<%@ include file="/WEB-INF/views/common/footer.jsp"%>























