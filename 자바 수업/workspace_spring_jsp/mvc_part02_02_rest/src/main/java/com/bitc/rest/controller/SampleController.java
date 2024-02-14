package com.bitc.rest.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.bitc.rest.vo.SampleVO;

// @Controller
@RestController
public class SampleController {

	@GetMapping("testJSON")
	public String testJSON(Model model){
		model.addAttribute("Hello faker");
		return "JSON";
	}
	
	@GetMapping("sample")
	public String getSample(
			String name,
			int age,
			SampleVO vo,
			Model model) {
		model.addAttribute("name",name);
		model.addAttribute("age",age);
		model.addAttribute("sample",vo);
		return "JSON";
	}
	/**
		BeanNameViewResover를 대신하는  annotation
	*/
	@GetMapping("sampleList")
	@ResponseBody
	public List<SampleVO> sampleList(){
		List<SampleVO> sampleList = new ArrayList<>();
		for(int i = 0; i < 10; i++) {
			SampleVO vo = new SampleVO();
			vo.setName("CGG-"+i);
			vo.setAge(i);
			sampleList.add(vo);
		}
		return sampleList;
	}
	
	@GetMapping("sample2")
	public SampleVO sample2(SampleVO vo) {
		return vo;
	}
	
	@PostMapping("sampeList")
	public List<SampleVO> sampleListPost(SampleVO vo){
		System.out.println("sampleList post vo : " + vo);
		List<SampleVO> list = new ArrayList<>();
		list.add(vo);
		for(int i = 0; i < 10; i++) {
			SampleVO sample = new SampleVO();
			vo.setAge(i);;
			vo.setName("temp-"+i);
			list.add(sample);
		}
		return list;
	}
	
	@PutMapping("sampleList")
	public SampleVO samplePut(@RequestBody SampleVO vo) {
		System.out.println("sampleList put vo : " + vo);
		return vo;
	}
	
}

