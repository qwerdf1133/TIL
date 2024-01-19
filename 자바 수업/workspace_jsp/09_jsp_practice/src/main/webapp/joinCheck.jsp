<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List, vo.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<!-- joinCheck.jsp -->
<%request.setCharacterEncoding("utf-8");%>

<%
	List<MemberVO> memberList = (List<MemberVO>)application.getAttribute("memberList");
	if(memberList == null){
		memberList = new ArrayList<>();
		application.setAttribute("memberList", memberList);
	}
	
	String id = request.getParameter("id");
	String pass = request.getParameter("pass");
	String name = request.getParameter("name");
	String addr = request.getParameter("addr");
	String phone = request.getParameter("phone]");
	String gender = request.getParameter("gender");
	Integer age = (Integer)request.get("age");
	
	
%>








