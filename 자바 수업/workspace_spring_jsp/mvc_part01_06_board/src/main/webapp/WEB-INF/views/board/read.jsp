<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>read.jsp</title>
</head>
<body>
	<h3>READ BAORD</h3>
	<!-- model boardVO -->
	<div>
			<label>TITLE</label>
			<input type="text" name="title" value="${boardVO.title}" readonly/>
		</div>
		<div>
			<label>CONTENT</label>
			<textarea name="content" readonly rows=3>${boardVO.content}</textarea>
		</div>
		<div>
			<label>WRITER</label>
			<input type="text" name="writer" value="${boardVO.writer}" readonly/>
		</div>
		<div>
			<a href="modify?bno=${boardVO.bno}">MODIFY</a> |
			<a href="remove?bno=${boardVO.bno}">DELETE</a> |
			<a href="listPage">LIST</a>
		</div>
	<script>
		var result = '${result}';
		if(result != null && result != ''){
			alert(result);
		}
	</script>
</body>
</html>




