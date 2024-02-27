package com.bitc.mvc.interceptor;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.bitc.mvc.vo.TestVO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TestInterceptor implements HandlerInterceptor{

	@Autowired(required=false)
	TestVO test;
	
	@Override
	public boolean preHandle(
			HttpServletRequest request, 
			HttpServletResponse response, 
			Object handler)
			throws Exception {
		log.info("TestInterceptor preHandler START =============");
		HandlerMethod method = (HandlerMethod)handler;
		log.info("controller : {} " , method.getBean());
		log.info("methodObj : {} " , method);
		log.info("-----------------------------------");
		log.info("test vo bean : {} ", method);
		log.info("-----------------------------------");
		String command
			= request.getRequestURI().substring(request.getContextPath().length() + 1);
		log.info("command : {}" , command);
		if(command.equals("test3")) {
			response.sendRedirect("test1");
			log.info("testIntegerceptor prehandler return false");
			return false;
		}
		
		log.info("TestInterceptor preHandler END =============");
		return true;
	}

	/**
	 * Controller 의 mapping method가 호출 완료되고 난 후
	 * DispatcherServlet으로 반환값이(ModelAndView) 반환 되고 난 후 호출
	 */
	@Override
	public void postHandle(
			HttpServletRequest request, 
			HttpServletResponse response, 
			Object handler,
			ModelAndView modelAndView) throws Exception {
		log.info("TestInterceptor postHandle START =======");
		log.info("ModelAndView : {} " , modelAndView);
		
		Map<String, Object> map = modelAndView.getModel();
		for(String key : map.keySet()) {
			log.info("key : {} " , key);
			log.info("value : {} " , map.get(key));
		}
		
		String viewName = modelAndView.getViewName();
		log.info("viewName : {}" , viewName);
		if(viewName.equals("test4")) {
			modelAndView.setViewName("home");
		}
		
		Object o = map.get("result");
		if(o == null) {
			modelAndView.addObject("result", "postHandle job");
		}
		
		// JSP 페이지에서 추가한 속성값 result1
		String result1 = (String)request.getAttribute("result1");
		log.info("Post Handle result1 : {} " , result1);
		log.info("TestInterceptor postHandle END =======");
	}

	/**
	 * DispatcherServlet이 JSP 또는 response 객체를 통하여 응답 출력을 
	 * 완료 하고 난 후 호출
	 */
	@Override
	public void afterCompletion(
			HttpServletRequest request, 
			HttpServletResponse response, 
			Object handler, Exception ex)
			throws Exception {
		log.info("TestInterceptor afterCompletion START =======");
		log.info("response content-type : {} ", response.getContentType());		
		log.info("after result : {} " , request.getAttribute("result"));
		log.info("after result1 : {} " , request.getAttribute("result1"));
		log.info("TestInterceptor afterCompletion END =======");
	}
	
	
}
