<%@page import="java.sql.*"%>
<%@page import="util.JDBCUtil"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- memberUpdate.jsp -->
<%@ include file="checkAdmin.jsp" %>
<%
	String id = request.getParameter("id");
	String pass = request.getParameter("pass");
	String name = request.getParameter("name");
	String addr = request.getParameter("addr");
	String phone = request.getParameter("phone");
	String gender = request.getParameter("gender");
	String strAge = request.getParameter("age");
	int age = Integer.parseInt(strAge);
	
	Connection conn = JDBCUtil.getConnection();
	String sql = "UPDATE test_member SET ";
	       sql +=" pass = ? , ";
	       sql +=" name = ? , ";
	       sql +=" addr = ? , ";
	       sql +=" phone = ? , ";
	       sql +=" gender = ? , ";
	       sql +=" age = ? ";
	       sql +=" WHERE id = ? ";
	PreparedStatement pstmt = conn.prepareStatement(sql);	
	pstmt.setString(1,pass);
	pstmt.setString(2,name);
	pstmt.setString(3,addr);
	pstmt.setString(4,phone);
	pstmt.setString(5,gender);
	pstmt.setInt(6,age);
	pstmt.setString(7,id);
	
	pstmt.executeUpdate();
	JDBCUtil.close(pstmt,conn);
	response.sendRedirect("memberList.jsp");
%>

















