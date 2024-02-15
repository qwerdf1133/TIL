package com.bitc.rest.comment.controller;

import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bitc.rest.comment.model.CommentVO;
import com.bitc.rest.comment.service.CommentService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/comment")
@RequiredArgsConstructor
public class CommentController {
	
	private final CommentService cs;
	
	// Post : comment
	@PostMapping("")
	public ResponseEntity<String> addComment(CommentVO vo){
		System.out.println(vo);
		ResponseEntity<String> entity = null;
		HttpHeaders headers = new HttpHeaders();
		try {
			String message = cs.addComment(vo);
			// headers.setContentType(new MediaType("text","plain",Charset.forName("utf-8")));
			// headers.setContentType(MediaType.TEXT_PLAIN);
			headers.add("Content-Type","text/plain;charset=utf-8");
			entity = new ResponseEntity<>(message,headers,HttpStatus.OK);
		} catch (Exception e) {
			entity = new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
		}
		return entity;
		// return ResponseEntity.ok().build();
		// return ResponseEntity.badRequest().build();
	}
	
	// 전체 댓글 목록
	// comment/"+bno+"/list
	@GetMapping("/{bno}/list")
	public List<CommentVO> commentList(@PathVariable(name="bno") int bno) throws Exception{
		System.out.println(bno);
		List<CommentVO> list = cs.commentList(bno);
		return list;
	}

}











