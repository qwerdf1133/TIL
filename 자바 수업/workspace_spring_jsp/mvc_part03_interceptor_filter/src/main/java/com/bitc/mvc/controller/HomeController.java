package com.bitc.mvc.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bitc.mvc.vo.TestVO;

@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home() {
		logger.info("HomeController home call");
		return "home";
	}
	
	@GetMapping("test1")
	public String test1() {
		logger.info("HomeController test1 요청");
		return "home";
	}
	
	@PostMapping("test2")
	public String test2(TestVO vo, Model model) {
		logger.info("HomeController test2 요청");
		logger.info("test2 vo : {} ", vo);
		model.addAttribute("result","test2 job");
		logger.info("HomeController test2 요청 처리 완료");
		return "home";
	}
	
	@GetMapping("test3")
	public String test3() {
		logger.info("HomeController test3 요청");
		return "home";
	}
	
	@GetMapping("test4")
	public void test4() {
		logger.info("HomeController test 4 요청");
	}
}













