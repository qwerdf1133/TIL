<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="connection.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원목록</title>
</head>
<body>
	<%
		Statement stmt = conn.createStatement();
		String sql = "SELECT num, name, addr FROM member ORDER BY num DESC";
		ResultSet rs = stmt.executeQuery(sql);
	%>
	<h1>등록된 회원 목록</h1>
	<table border="1">
		<tr>
			<th colspan="4">회원정보</th>
		</tr>
		<tr>
			<th>번호</th>
			<th>이름</th>
			<th>주소</th>
			<th>비고</th>
		</tr>
	<%
		while(rs.next()){
			// 다음 next()를 호출 하기 전까지 한 행에 대한 정보
			// num, name, addr
			int num = rs.getInt("num"); 			// 1
			String name = rs.getString("name");		// 2
			String addr = rs.getString("addr");		// 3
	%>
			<%-- <h4><%=num%>-<%=name%>-<%=addr%></h4> --%>
			<tr onclick="location.href='updateForm.jsp?num=<%=num%>';" title="회원정보 수정 : <%=num%>">
				<td><%=num%></td>	<!-- 회원번호 -->
				<td><%=name%></td>	<!-- 회원이름 -->
				<td><%=addr%></td>	<!-- 회원주소 -->
				<td></td>			<!-- 회원비고 -->
				<td>
					<!-- 회원 삭제 -->
					<form action="deleteExecute.jsp" method="POST">
						<input type="hidden" name="num" value="<%=num%>"/>
						<button>삭제</button>
					</form>
				</td>
			</tr>
	<%
		} // end result set while
			
		if(stmt != null) stmt.close();
		if(conn != null) conn.close();
	%>
	</table>
	<hr/>
	<a href="index.jsp">메인으로</a>
</body>
</html>






