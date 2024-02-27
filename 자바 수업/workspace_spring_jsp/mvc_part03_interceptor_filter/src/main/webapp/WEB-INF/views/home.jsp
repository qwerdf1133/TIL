<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>home.jsp</title>
</head>
<body>
	<h2>result : ${result}</h2>
	<a href="test1">test1</a> <br/>
	<hr/>
	<form action="test2" method="POST">
		<input type="number" name="a" /> <br/>
		<input type="text" name="b" /> <br/>
		<button>확인</button> 
	</form>
	<hr/>
	<a href="test3">test3</a> <br/>
	<a href="test4">test4</a>
</body>
</html>
<%
	System.out.println("------------------------HOME JSP 출력완료");
	request.setAttribute("result1", "Home JSP Value");
%>








