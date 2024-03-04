package com.bitc.user.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.bitc.user.service.UserService;
import com.bitc.user.vo.LoginDTO;
import com.bitc.user.vo.UserVO;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("user")
@RequiredArgsConstructor
public class UserController {
	
	/**
	 * 필수 인자값을 가진 생성자를 이용한 의존성 주입
	 */
	private final UserService us;
	
	@RequestMapping("/signIn")
	public String signIn() {
		return "user/signIn";
	}
	
	@GetMapping("/signUp")
	public void signUp() {}

	
	@PostMapping("/signUpPost")
	public String signUpPost(UserVO vo, RedirectAttributes rttr) throws Exception{
		us.signUp(vo);
		rttr.addFlashAttribute("message","회원가입성공");
		return "redirect:/user/signIn";
	}
	
	@PostMapping("/signInPost")
	public ModelAndView signInPost(LoginDTO dto,HttpSession session) throws Exception{
		ModelAndView mav = new ModelAndView();
		UserVO userVO = us.signIn(dto);
		session.setAttribute("userInfo", userVO);
		mav.setViewName("redirect:/");
		return mav;
	}
	
	@GetMapping("/signOut")
	public String signOut(
			HttpServletResponse response,
			// HttpServletRequest request,
			@CookieValue(name="signInCookie", required=false) Cookie cookie,
			HttpSession session) throws Exception{
		session.removeAttribute("userInfo");
		// Cookie cookie = WebUtils.getCookie(request, "signInCookie");
		if(cookie != null) {
			cookie.setPath("/");
			cookie.setMaxAge(0);
			response.addCookie(cookie);
		}
		return "redirect:/";
	}
}




















