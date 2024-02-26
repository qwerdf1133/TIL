package com.bitc.controller;

import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bitc.service.MessageService;
import com.bitc.vo.MessageVO;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/messages")
@RequiredArgsConstructor
@Slf4j
public class MessageController {
	
	private final MessageService ms;
	
	
	@GetMapping("/list")
	public ResponseEntity<List<MessageVO>> readList(){
		try {
			List<MessageVO> list = ms.list();
			return new ResponseEntity<>(list,HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@PostMapping("/add")
	public ResponseEntity<String> addMessage(MessageVO vo){
		ResponseEntity<String> entity = null;
		
		try {
			log.info("MessageController : " + vo);
			ms.addMessage(vo);
			log.info("MessageController service 작업 수행 완료");
			entity = new ResponseEntity<>("SUCCESS",HttpStatus.OK);
		} catch (Exception e) {
			HttpHeaders header = new HttpHeaders();
			header.add("Content-Type","text/plain;charset=utf-8");
			entity = new ResponseEntity<>("error 입니다.",header,HttpStatus.BAD_REQUEST);
		}
		return entity;
	}
}


























