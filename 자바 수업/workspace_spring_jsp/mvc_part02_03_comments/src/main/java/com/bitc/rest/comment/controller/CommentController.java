package com.bitc.rest.comment.controller;

import java.util.List;
import java.util.Map;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bitc.board.util.Criteria;
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
	public List<CommentVO> commentList(
			@PathVariable(name="bno") int bno) throws Exception{
		System.out.println(bno);
		List<CommentVO> list = cs.commentList(bno);
		return list;
	}
	
	// comment/cno
	@PatchMapping(value="/{cno}", produces="text/plain;charset=utf-8")
	public ResponseEntity<String> update(
			@PathVariable(name="cno") int cno,
			@RequestBody CommentVO vo
			) {
		System.out.println(cno);
		System.out.println(vo);
		vo.setCno(cno);
		try {
			String result = cs.updateComment(vo);
			return ResponseEntity.ok(result);
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}
	
	// comment/cno
	@DeleteMapping(value="/{cno}", produces="text/plain;charset=utf-8")
	public String delete(
			@PathVariable(name="cno") int cno
			) throws Exception{
		return cs.deleteComment(cno);
	}
	
	// "comment/"+bno+"/"+page;
	@GetMapping("/{bno}/{page}/{perPageNum}")
	// 페이징 처리된 댓글 목록과 이동할 수 있는 페이지 번호의 정보를 저장하는 페이징 블럭 
	// 정보를 Map에 저장하여 반환
	// data : { list : List<CommentVO> , pm :  PageMaker }
	public Map<String, Object> listPage(
				@PathVariable("bno") int bno,
				// @PathVariable("page") int page
				Criteria cri) throws Exception{
		System.out.println(cri);
		// Criteria cri = new Criteria(page, 5);
		return cs.commentListPage(bno, cri);
	}

}











