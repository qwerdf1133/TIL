package com.bitc.common.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;

import com.bitc.board.mapper.BoardMapper;
import com.bitc.board.vo.BoardVO;
import com.bitc.user.vo.UserVO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class AuthInterceptor implements HandlerInterceptor {
	
	@Autowired
	BoardMapper mapper;
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		log.info("AuthInterceptor preHandler START");
		// 전체 URL 요청 경로
		String requestURI = request.getRequestURI();
		// 프로젝트 경로
		String contextPath = request.getContextPath();
		// session에 저장된 로그인된 사용자 정보
		Object obj = request.getSession().getAttribute("userInfo");
		if(obj == null) {
			// 미로그인 사용자
			response.sendRedirect(contextPath+"/user/signIn");
			return false;
		}else {
			// 로그인된 사용자
			if(requestURI.equals(contextPath+"/board/register")) {
				// 새 원본글 작성 요청
				return true;
			}
			
			// 답변글 요청, 수정 요청, 삭제 요청
			String num = request.getParameter("bno");
			/*
			 * [-+]?  하나또는 없거나
			 *  문자열 맨 앞에 + 문자와 - 문자를 허용한다.
			 *  \\d*
			 *  문자열에 최소한 하나 이상의 수샂가 존재해야한다.
			 *  \\.\\d+
			 *  - 0 ~ 1개의 소수점을 허용한다.
			 */
			String regex = "[-+]?\\d*\\.?\\d+";
			if(num != null && !num.trim().equals("") && num.matches(regex)) {
				int bno = Integer.parseInt(num);
				
				if(requestURI.equals(contextPath+"/board/replyRegister")) {
					log.info("답변글 작성 요청");
					return true;
				}
				
				// 수정 , 삭제 요청
				BoardVO board = mapper.readBoard(bno);
				// 로그인된 사용자 정보
				UserVO userInfo = (UserVO)obj;
				if(board.getUno() == userInfo.getUno()) {
					// 수정 삭제 권한이 있는 사용자 - 로그인된 사용자가 게시글을 작성한 사용자
					return true;
				}else {
					response.sendRedirect(contextPath+"/board/read?bno="+bno);
					return false;
				}
				
			}else {
				response.sendRedirect(contextPath+"/board/listReply");
				return false;
			}
		}
	}
	
	

}






