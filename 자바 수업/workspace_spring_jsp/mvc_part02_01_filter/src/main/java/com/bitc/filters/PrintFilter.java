package com.bitc.filters;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PrintFilter implements Filter{
	
	private String filePath;
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		System.out.println("PrintFilter init 시작======");
		filePath = filterConfig.getInitParameter("filePath");
		System.out.println("filePath : " + filePath);
		System.out.println("PrintFilter init 종료======");
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("PrintFilter doFilter 시작======");
		
		String realPath = request.getServletContext().getRealPath(filePath);
		System.out.println(realPath);
		
		String logPath = request.getServletContext().getRealPath("/log");
		System.out.println("logPath : " + logPath);
		File log = new File(logPath);
		// log directory가 존재 하지 않으면
		if(!log.exists()) {
			// 디렉토리 부터 생성
			log.mkdirs();
		}
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		// 요청이 들어온 시간 정보를 문자열로 저장
		String date = sdf.format(System.currentTimeMillis());
		
		HttpServletRequest req = (HttpServletRequest) request;
		// 요청 경로
		String requestURI = req.getRequestURI();
		// 요청 방식
		String method = req.getMethod();
		// 요청 ip
		String ip = req.getRemoteAddr();
		File file = new File(realPath);
		PrintWriter pw = new PrintWriter(
			new FileWriter(file,true) // append 이어쓰기
		);
		pw.println("===============================");
		pw.printf("로그 시간 : %s %n", date);
		pw.printf("요청 IP : %s %n", ip);
		pw.printf("요청 경로 : %s %n", requestURI);
		pw.printf("전송 방식 : %s %n", method);
		
		chain.doFilter(request, response);
		HttpServletResponse res = (HttpServletResponse)response;
		pw.printf("응답 코드 %d %n", res.getStatus());
		pw.println("===============================");
		pw.flush();
		pw.close();
		System.out.println("PrintFilter doFilter 종료======");
	}

}