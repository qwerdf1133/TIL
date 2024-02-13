package com.bitc.controller;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bitc.vo.MemberVO;

@Controller
public class HomeController {
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home() {
		System.out.println("home 호출");
		return "home";
	}
	
	@GetMapping("write")
	public void write() {
		System.out.println("write 호출");
		// return "write"; // "/WEB-INF/views/" + "write" + ".jsp";
	}
	
	@PostMapping("write")
	public String write(
			String id, String pw, String name,
			MemberVO member,
			HttpServletRequest request
			) throws UnsupportedEncodingException {
		System.out.println(request.getCharacterEncoding());
		request.setCharacterEncoding("UTF-8");
		id = request.getParameter("id");
		pw = request.getParameter("pw");
		name = request.getParameter("name");
		System.out.println("id : " + id);
		System.out.println("pw : " + pw);
		System.out.println("name : " + name);
		System.out.println("member : " + member);
		return "redirect:/"; // response.sendRedirect("/");
	}
	
}
















