<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>register.jsp</title>
</head>
<body>
	<h1>REGISTER BOARD</h1>
	<!-- action 생략 시 현재 주소 표시줄 요청으로 다시 요청 -->
	<form method="POST">
		<div>
			<label>TITLE</label>
			<input type="text" name="title"/>
		</div>
		<div>
			<label>CONTENT</label>
			<textarea name="content" rows=3></textarea>
		</div>
		<div>
			<label>WRITER</label>
			<input type="text" name="writer"/>
		</div>
		<div>
			<input type="submit" value="글작성 완료"/>
		</div>
	</form>
</body>
</html>












