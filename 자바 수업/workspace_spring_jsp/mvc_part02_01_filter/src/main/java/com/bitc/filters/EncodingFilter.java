package com.bitc.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

public class EncodingFilter implements Filter{
	
	private String encoding;
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// Filter가 등록되기전 인스턴스 생성 후 최초에 한번 호출 
		System.out.println("init EncodingFilter Start");
		encoding = filterConfig.getInitParameter("encoding");
		System.out.println("init EncodingFilter End : " +encoding);
	}

	@Override
	public void destroy() {
		System.out.println("EncodingFilter instance 제거");
	}

	@Override
	public void doFilter(ServletRequest request, 
						ServletResponse response, 
						FilterChain chain)
			throws IOException, ServletException {
		System.out.println("Encoding Filter doFilter START");
		// DispatcherServlet 이 요청을 처리하기 전 처리
		HttpServletRequest req = (HttpServletRequest)request;
		String method = req.getMethod();
		if(method.equalsIgnoreCase("POST")) {
			System.out.println("POST 요청 - request encoding 지정");
			request.setCharacterEncoding(encoding);
		}
		
		// FilterChain에 등록된 다른 Filter의 doFilter method 호출
		// FilterChain이 모든 doFilter method가 호출 되가 나면
		// DispatcherServlet 의 요청 전달 후 결과 확인
		chain.doFilter(request, response);
		
		// DispatcherServlet 이 요청을 처리하고 난 후 처리
		System.out.println("Encoding Filter doFilter END");
	}

}















