<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>result.jsp</h1>
	
	 <h3>result pageContext : <%=pageContext.getAttribute("index") %></h3>
	 <h3>result request : <%=request.getAttribute("index") %></h3>
	 
	 <a href="redirect?id=chlrlrms">response send redirect</a> <br/>
	 <hr/>
	 <a href="forward?id=hap0p9y">dispatcher forward</a>
</body>
</html>

















