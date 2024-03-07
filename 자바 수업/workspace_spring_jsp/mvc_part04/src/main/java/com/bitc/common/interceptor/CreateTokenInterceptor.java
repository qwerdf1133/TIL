package com.bitc.common.interceptor;

import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;

public class CreateTokenInterceptor implements HandlerInterceptor {

	/**
	 * CSRF 공격(Cross Site Request Forgery)
	 * 웹 애플리케이션의 취약점 중 하나로 인터넷 사용자(희생자)가
	 * 자신의 의지와는 무관하게 공격자가 의도한 행의(수장, 삭제 , 등록 등)을
	 * 특정 웹사이트에 요청하게 만드는 공격
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		HttpSession session = request.getSession();
		String token = UUID.randomUUID().toString();
		session.setAttribute("csrf_token", token);
		return true;
	}
	
	

}





