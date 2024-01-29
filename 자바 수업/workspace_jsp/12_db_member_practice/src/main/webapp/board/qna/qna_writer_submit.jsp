<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Connection"%>
<%@page import="util.JDBCUtil"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="vo.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// 게시물 등록 요청 처리
	MemberVO member = (MemberVO)session.getAttribute("login");
	String qna_name = member.getName();		// 로그인 된 회원 이름
	int qna_writer_num = member.getNum();	// 로그인 된 회원 번호
	// request에서 전닫뢴 게시글 등록에 필요한 제목, 내용
	String qna_title = request.getParameter("qna_title");
	String qna_content = request.getParameter("qna_content");
	
	Connection conn = JDBCUtil.getConnection();
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	String sql = "INSERT INTO qna_board(qna_name, qna_title, qna_Content, qna_writer_num) VALUES(?,?,?,?)";
	
	try{
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, qna_name);
		pstmt.setString(2, qna_title);
		pstmt.setString(3, qna_content);
		pstmt.setInt(4, qna_writer_num);
		pstmt.executeUpdate();
		
		JDBCUtil.close(pstmt);
		
		sql = "SELECT LAST_INSERT_ID()";
		pstmt = conn.prepareStatement(sql);
		rs = pstmt.executeQuery();
		int qna_num = 0;
		if(rs.next()){
			qna_num = rs.getInt(1);
		}
		
		JDBCUtil.close(rs,pstmt);
		
		sql = "UPDATE qna_board SET qna_re_ref = ? WHERE qna_num = ?";
		pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, qna_num);
		pstmt.setInt(2, qna_num);
		int result = pstmt.executeUpdate();
		System.out.println("result : " + result);
		if(result == 1){
			conn.commit();
		}else{
			conn.rollback();
		}
		
		response.sendRedirect("qna_list.jsp");
	}catch(Exception e){
		e.printStackTrace();
		conn.rollback();
	}finally{
		conn.setAutoCommit(true);
		JDBCUtil.close(pstmt,conn);
	}
	
	
%>	