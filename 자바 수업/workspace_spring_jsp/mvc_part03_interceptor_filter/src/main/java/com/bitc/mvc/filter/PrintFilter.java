package com.bitc.mvc.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;

import org.springframework.beans.factory.annotation.Autowired;

import com.bitc.mvc.vo.TestVO;

import lombok.extern.slf4j.Slf4j;

@WebFilter(
	urlPatterns = "/*",
	initParams = {@WebInitParam(name="encoding", value="UTF-8")}
)

@Slf4j
public class PrintFilter implements Filter{
	
	@Autowired(required = false)
	TestVO test;
	
	private String encodingName;

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		log.info("PrintFilter 초기화 시작 ---");
		encodingName = filterConfig.getInitParameter("encoding");
		log.info("PrintFilter 초기화 종료 ---");
	}

	@Override
	public void doFilter(
			ServletRequest request, 
			ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		log.info("PrinFilter doFilter START ----------------------");
		log.info("filter testVO injection : {} " , test);
		request.setCharacterEncoding(encodingName);
		chain.doFilter(request, response);
		log.info("PrinFilter doFilter END ----------------------");
	}
	
	@Override
	public void destroy() {
		log.info("PrintFilter destroy() ------");
	}

}










