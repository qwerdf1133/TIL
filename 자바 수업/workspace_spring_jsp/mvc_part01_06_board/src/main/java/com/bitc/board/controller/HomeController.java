package com.bitc.board.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(HttpSession session, Model model) {
		String message
			= (String)session.getAttribute("message");
		if(message != null) {
			model.addAttribute("msg",message);
			session.removeAttribute("message");
		}
		return "home";
	}

}
