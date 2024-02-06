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
	
	// method�� ���� �Ǹ� GET, POST �Ѵ� ó��
	@RequestMapping("doA")
	// /WEB-INF/views/ + doA + .jsp
	public void doA() {
		System.out.println("doA ȣ��");
	}
	
	@RequestMapping("doB")
	public String doB() {
		System.out.println("doB ��û");
		return "home";
	}
	
	@RequestMapping("doC")
	public String doC(HttpServletRequest request){
		System.out.println("doC ȣ��");
		String msg = request.getParameter("msg");
		request.setAttribute("modelTest", msg);
		return "home";
	}
	
	@RequestMapping(value="doD", method= RequestMethod.GET)
	public String doD(
			@RequestParam(name="msg" , required=false, defaultValue="empty message") String message,
			Model model) {
		// �Ű����� �̸��� ��ġ�ϴ� �Ķ���͸� request���� ã�Ƽ� ȣ�� �� ����
		System.out.println("doD ȣ�� msg : " + message);
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
		
		// key ���� ���� �Ǿ��� ���
		// ProductVO class ���޵� class�� name���� ù���ڸ� �ҹ��ڷ� ġȯ�Ͽ� key ����
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












