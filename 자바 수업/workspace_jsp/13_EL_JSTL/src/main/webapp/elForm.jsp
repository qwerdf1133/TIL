<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Expression Language - 표현 언어</h1>
	<h3>pageContext &lt; request &lt; session &lt; application</h3>
	<h2>
		4대 영역 객체의 속성값을 jsp page내에서 쉽게 연산하고 읽어서 출력할 수 있도록
		구성된 언어 
	</h2>
<%
	pageContext.setAttribute("scopeName","pageContext 영역");
	request.setAttribute("scopeName","request 영역");
	session.setAttribute("scopeName","session 영역");
	application.setAttribute("scopeName","application 영역");
%>
page 영역 : <%=pageContext.getAttribute("scopeName") %>	<br/>
request 영역 : <%=pageContext.getAttribute("scopeName") %>	<br/>
session 영역 : <%=pageContext.getAttribute("scopeName") %>	<br/>
application 영역 : <%=pageContext.getAttribute("scopeName") %>	<br/>

<h3>EL 표현식 - \${영역객체.속성 key }</h3>
page EL : \${pageScope.scopeName} <br/>
requestEL : \${requestScope.scopeName} <br/>
session EL : \${sessionScope.scopeName} <br/>
application EL : \${applicationScope.scopeName} <br/>
<hr/>
<% pageContext.removeAttribute("scopeName"); %>
EL scopeName : ${scopeName}
<br/>
<% session.setAttribute("member","최기근"); %>
EL member : ${member}
<br/>
findAttribute : <%= pageContext.findAttribute("member") %> <br/>
<hr/>
<form action="elTest.jsp">
	<input type="text" name="id" />
	<button type="submit">확인</button>
</form>
<br/>
</body>
</html>

