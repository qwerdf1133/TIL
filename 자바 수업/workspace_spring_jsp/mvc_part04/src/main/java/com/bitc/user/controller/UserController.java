package com.bitc.user.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.bitc.user.service.UserService;
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
}




















