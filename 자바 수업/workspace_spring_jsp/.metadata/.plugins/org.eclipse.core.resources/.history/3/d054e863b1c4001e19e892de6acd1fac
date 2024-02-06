package com.bitce.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {
	
	public HomeController() {
		System.out.println("HomeController 생성...");
	}
	
	@RequestMapping(value = "main.home", method = RequestMethod.GET)
	public String home(HttpSession session, Model model) {
		System.out.println("main.home 요청 처리 method 실행");
		session.setAttribute("test", "session test");
		model.addAttribute("modelTest", "test model");
		// "/WEB-INF/views/"+"home" +".jsp"
		return "home";
	}
	
}











