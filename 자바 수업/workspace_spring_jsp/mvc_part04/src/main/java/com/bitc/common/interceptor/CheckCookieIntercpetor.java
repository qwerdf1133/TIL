package com.bitc.common.interceptor;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.util.WebUtils;

import com.bitc.user.mapper.UserMapper;
import com.bitc.user.vo.UserVO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CheckCookieIntercpetor implements HandlerInterceptor{
	
	@Autowired
	UserMapper mapper;

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		HttpSession session = request.getSession();
		if(session.getAttribute("userInfo") != null) {
			log.info("이미 로그인된 사용자");
			return true;
		}
		// request로 전달된 쿠키들 중이 name 이 signInCookie를 찾아서 반환 없으면 null
		Cookie cookie = WebUtils.getCookie(request, "signInCookie");
		if(cookie != null) {
			String uid = cookie.getValue();
			UserVO userInfo = mapper.getUserById(uid);
			session.setAttribute("userInfo", userInfo);
			log.info("Cookie 로 session 정보 등록 : {} ", userInfo);
		}
		/*
		Cookie[] cookies = request.getCookies();
		if(cookies != null) {
			for(Cookie c : cookies) {
				if(c.getName().equals("signInCookie")) {
					String uid = c.getValue();
					UserVO userInfo = mapper.getUserById(uid);
					session.setAttribute("userInfo", userInfo);
					log.info("Cookie 로 session 정보 등록 : {} ", userInfo);
				}
			}
		}
		*/
		return true;
	}
	
	

}
