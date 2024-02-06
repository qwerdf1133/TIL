package com.bitce.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.bitce.vo.ProductVO;

@Controller
public class SampleController {
	
	// method가 제외 되면 GET, POST 둘다 처리
	@RequestMapping("doA")
	// /WEB-INF/views/ + doA + .jsp
	public void doA() {
		System.out.println("doA 호출");
	}
	
	@RequestMapping("doB")
	public String doB() {
		System.out.println("doB 요청");
		return "home";
	}
	
	@RequestMapping("doC")
	public String doC(HttpServletRequest request){
		System.out.println("doC 호출");
		String msg = request.getParameter("msg");
		request.setAttribute("modelTest", msg);
		return "home";
	}
	
	@RequestMapping(value="doD", method= RequestMethod.GET)
	public String doD(
			@RequestParam(name="msg" , required=false, defaultValue="empty message") String message,
			Model model) {
		// 매개변수 이름과 일치하는 파라미터를 request에서 찾아서 호출 시 전달
		System.out.println("doD 호출 msg : " + message);
		model.addAttribute("msg",message);
		return "result";
	} // end doD
	
	@RequestMapping(value="doF", method=RequestMethod.POST)
	public String doF(String name, int age, Model model) {
		model.addAttribute("msg", name+":"+age);
		return "result";
	}
	
	@RequestMapping(value="productWrite", method=RequestMethod.POST)
	public String product(
				ProductVO product,
				String name, int price, 
				Model model) {
		System.out.println("param product : " + product);
		ProductVO vo = new ProductVO(name,price);
		model.addAttribute("product", vo);
		model.addAttribute(product);
		return "product";
	}
	
//  @RequestMapping(value="productWriteSubmit", method=RequestMethod.POST)	
	@PostMapping("productWriteSubmit")
	public ModelAndView productWriteSubmit(ModelAndView mav, ProductVO prod) {
		System.out.println("productWriteSubmit : " + prod);
		
		mav.addObject("product", prod);
		
		// key 값이 제외 되었을 경우
		// ProductVO class 전달된 class의 name에서 첫글자만 소문자로 치환하여 key 지정
		// productVO
		mav.addObject(prod);
		
		mav.setViewName("product");
		
		return mav;
	}
	
	
	@GetMapping("redirect")
	public String redirect() {
		return "redirect:main.home";
	}
	
}












