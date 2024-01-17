<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="common/header.jsp" %>
    <main>
    	<article>
    		<h1>MAIN 본문 내용입니다.</h1>
    	</article>
    	<section>
    		<h3><%=s%></h3>
    		<%@ include file="content.jsp" %>
    		<%! String result = "본문에서 선언된 필드"; %>
    		<%= result %>
    	</section>
    </main>
<%@ include file="common/footer.jsp" %>