package com.bitc.common.interceptor;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.bitc.user.vo.LoginDTO;
import com.bitc.user.vo.UserVO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SignInInterceptor implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		HttpSession session = request.getSession();
		if(session.getAttribute("userInfo") != null) {
			session.removeAttribute("userInfo");
		}
		return true;
	}

	@Override
	public void postHandle(
			HttpServletRequest request, 
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		HttpSession session = request.getSession();
		UserVO userInfo = (UserVO)session.getAttribute("userInfo");
		log.info("------ interceptor user info : {} " , userInfo);
		
		ModelMap modelObj = modelAndView.getModelMap();
		LoginDTO dto = (LoginDTO)modelObj.get("loginDTO");
		log.info("------ interceptor login dto : {} " , dto);
		
		if(userInfo != null) {
			// 정상적으로 로그인된 상태
			
			if(dto.isUserCookie()) {
				// 자동로그인 요청
				Cookie cookie = new Cookie("signInCookie", userInfo.getUid());
				cookie.setPath("/");
				cookie.setMaxAge(60 * 60 * 24 * 15);
				response.addCookie(cookie);
			}
		}else {
			// 잘못된 사용자 정보로 로그인 요청
			String message = "로그인 실패";
			modelAndView.addObject("message",message);
			modelAndView.setViewName("/user/signIn");
		}
		
	}
	
}





















