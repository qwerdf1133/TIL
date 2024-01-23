<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>방명록 메세지 목록</title>
</head>
<body>
	<!-- 방명록 작성 -->
	<form action="<%=request.getContextPath()%>/guestbook/guestbook_write.jsp" method="POST">
		<table>
			<tr>
				<th colspan="3"><h2>방명록 작성</h2></th>
			</tr>
			<tr>
				<td colspan="2"></td>
				<td rowspan="4">
					<input type="submit" style="margin-left:20px;width:100%;height:100px;" value="메세지 남기기"/>
				</td>
			</tr>
			<tr>
				<td>이름</td>
				<td>
					<input type="text" name="guestName" style="width:100%"/>
				</td>
			</tr>
			<tr>
				<td>암호</td>
				<td>
					<input type="password" name="password" style="width:100%"/>
				</td>
			</tr>
			<tr>
				<td>메세지</td>
				<td>
					<textarea name="message" cols="35" rows="3"></textarea>
				</td>
			</tr>
		</table>
	</form>
	
	<hr/>
	<!-- 방명록 목록 -->
	<%@ page import="java.sql.*, util.*" %>
	<%
		// 요청이 들어온 페이지 요청한 페이지 정보가 없을 때는 1page출력
		int currentPage = 1;
		// 한 페이지에 보여줄 게시물 개수
		int pageCount = 10;
		// 테이블에 pageCount만큼 검색할 limit의 시작 인덱스 번호
		int startRow = 0;
		
		String paramPage = request.getParameter("page");
		if(paramPage != null){
			currentPage = Integer.parseInt(paramPage);
		}
		out.println("현재 요청 페이지 : " + currentPage+"<br/>");
		// 1page : ==  0 == (1-1) * 10 == 0;
		// 2page : == 10 == (2-1) * 10 == 10;
		// 3page : == 20 == (3-1) * 10 == 20;
		// ...
		// pageCount == 5
		// 1page : ==  0 == (1-1) * 5 == 0;
		// 2page : == 5 == (2-1) * 5 == 5;
		// 3page : == 10 == (3-1) * 5 == 10;
		// ...
		startRow = (currentPage - 1) * pageCount;
		
		String sql = "SELECT * FROM test_guestbook ORDER BY num DESC limit ?, ?";
		Connection conn = JDBCUtil.getConnection();
		PreparedStatement pstmt = conn.prepareStatement(sql);
		// table에서 select할 시작 인덱스 번호
		pstmt.setInt(1,startRow);
		// 한번에 출력할 게시글 개수
		pstmt.setInt(2, pageCount);
		ResultSet rs = pstmt.executeQuery();
	%>
	<h1>방명록 리스트</h1>
	<table border="1" cellspacing="0" cellpadding="0">
		<%
			while(rs.next()){
				int num = rs.getInt("num");
				String guestName = rs.getString("guestName");
				String message = rs.getString("message");
		%>
				<tr>
					<td>
						메세지 번호 : <%=num%> <br/>
						손님이름 : <%=guestName%> <br/>
						메세지 : <%=message %>
						<a href="">[삭제]</a>
					</td>
				</tr>
		<%
			} // end while
			JDBCUtil.close(rs,pstmt,conn);	
		%>
<!-- paging block 처리 -->
<%
	// table에 등록된 전체 행의 개수 - 게시물 개수
	conn = JDBCUtil.getConnection();
	sql = "SELECT count(*) FROM test_guestbook";
	Statement stmt = conn.createStatement();
	rs = stmt.executeQuery(sql);
	// 전체 게시물 개수를 저장할 변수
	int totalCount = 0;
	if(rs.next()){
		totalCount = rs.getInt(1);
	}
	JDBCUtil.close(rs,stmt,conn);
	// 6144 / 10 == 614.4 == 614
	// 130 : 130 / 10 == 13page + 1 == 14page
	// 129 : 129 / 10 == 12page + 1 == 13page
	// 이동할 수 있는 페이지 번호 - 최대 페이지 번호
	int maxPage = totalCount / pageCount + 1;
	
	// 현재 요청 페이지에서 보여줄 시작 페이지 번호
	int startPage = 0;
	// 현재 요청 페이지에서 보여줄 마지막 페이지 번호
	int endPage = 0;
	// 한번에 보여줄 페이지 번호 개수
	int displayPageNum = 5;
	
	//	[1][2][3][4][5]  1 ~  5 페이지 번호는 동일한 페이지 번호 출력
	//	[6][7][8][9][10] 6 ~ 10 페이지는 동일한 번호 출력
	// ...
	// 시작 페이지 번호
	// 1page : == 1 == (1-1) / 5 == (0*5)  + 1  == 1
	// 5page : == 1 == (5-1) / 5 == (0.8) == (0*5) + 1 == 1 
	// 6page : == 6 == (6-1) / 5 == (1*5) + 1 == 6
	// 10page: == 6 == (10 - 1) / 5 == 1.8 == (1*5) + 1 == 6
	// 11page: == 11 == (11-1) / 5 == (2*5) + 1 == 11
	// ...
	startPage = (currentPage - 1) / pageCount;
	// 출력될 마지막 페이지 번호
	endPage = startPage + (displayPageNum - 1);
	
%>
		<tr>
			<th>
<!-- 	이전 페이지 블럭		 -->
				<% if(startPage != 1){ %>
				<a href="<%=request.getContextPath()%>/guestbook/guestbook_list.jsp?page=<%=startPage-1%>">[이전]</a>
				<%} %>
				<%
					for(int i = startPage; i <= endPage; i++){
%>
					<a href="<%=request.getContextPath()%>/guestbook/guestbook_list.jsp?page=<%=i%>">[<%=i%>]</a>
<%
					}
				%>
				<!-- 다음 페이지 블럭 출력 -->
				<% if(endPage < maxPage){ %>
				<a href="<%=request.getContextPath()%>/guestbook/guestbook_list.jsp?page=<%=endPage+1%>">[다음]</a>
				<%}%>
			</th>
		</tr>
	</table>
	<br/>
	<br/>
	<br/>
	<br/>
	<br/>
	<br/>
	<br/>
	<br/>
	<br/>
	<br/>
</body>
</html>
