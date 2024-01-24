<%@page import="java.util.*, vo.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<!-- 회원가입 요청 처리 - joinCheck.jsp -->
<%
	request.setCharacterEncoding("utf-8");

	List<MemberVO> memberList = (List<MemberVO>)application.getAttribute("memberList");
	if(memberList == null){
		memberList = new ArrayList<>();
		application.setAttribute("memberList", memberList);
	}
	
	
	String id = request.getParameter("id");
	
	// 중복 아이디 체크
	MemberVO member = new MemberVO(id);
	
	if(!memberList.isEmpty() && memberList.contains(member)){
%>

	<script>
		alert('이미 사용중인 아이디입니다');
		history.go(-1);
	</script>



<% 		
		return; 
	}
	
	String pass = request.getParameter("pass");
	String name = request.getParameter("name");
	String addr = request.getParameter("addr");
	String phone = request.getParameter("phone");
	String gender = request.getParameter("gender");
	String strAge = request.getParameter("age");
	int age = Integer.parseInt(strAge); 
	
	member.setPass(pass);
	member.setAddr(addr);
	member.setName(name);
	member.setPhone(phone);
	member.setGender(gender);
	member.setAge(age);
	
	memberList.add(member);
	
	System.out.println("=========================================");
	System.out.println(application.getAttribute("memberList"));
	System.out.println("=========================================");
	
%>
<script>
	alert('회원가입 성공');
	location.href="login.jsp]";
</script>







