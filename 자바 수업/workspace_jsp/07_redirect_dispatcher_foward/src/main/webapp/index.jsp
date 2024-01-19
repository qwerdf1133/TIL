<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>index.jsp</h1>
	<!-- 
		jsp or servlet class에서
		자바 code를 통해 페이지를 전환하는 방법
		
		1. response
		요청에 따른 처리가 완료된 후에 응답을 받은 브라우저에게 
		지정한 페이지로 새롭게 요청(redirection)하라고 send
		response.sendRedirect("이동할페이지를 문자열로 전달");
		
		2. request -> RequestDispatcher -> forward
		요청을 받아 응답으로 출력하는 jsp페이지를 지정된 페이지로 변경하여 출력하는 방법
		request.getRequestDispatcher("출력할 페이지를 문자열로 전달").forward(request,response);
	 -->
	 
	 <%
	 	pageContext.setAttribute("index","temp1");
	 	request.setAttribute("index","temp2");
	 %>
	 
	 <h3>pageContext : <%=pageContext.getAttribute("index") %></h3>
	 <h3>request : <%=request.getAttribute("index") %></h3>
	 
	 <a href="result.jsp">result</a>
</body>
</html>




































