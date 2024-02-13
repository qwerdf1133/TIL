package com.bitc.board.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.bitc.board.service.BoardService;
import com.bitc.board.util.Criteria;
import com.bitc.board.util.PageMaker;
import com.bitc.board.vo.BoardVO;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class BoardController {
	
	private final BoardService bs;
	
	
	/* "게시글 작성 페이지 요청" */
	// @RequestMapping(value="/register",method=RequestMethod.GET)
	@GetMapping("board/register")
	public void register()throws Exception{
		// /board/register
		// WEB-INF/views/board/register.jsp
		System.out.println("게시글 작성 페이지 요청");
	}
	
	/**
	 * 게시글 등록 요청 처리 추가
	 */
	@PostMapping("board/register")
	public String registerPost(
				BoardVO vo,
				Model model)throws Exception{
		System.out.println("board/register post 요청");
		System.out.println(vo);
		String result = bs.regist(vo);
		model.addAttribute("msg",result);
		return "home";
	}
	
	
	/**
	 * 게시글 상세보기 요청 처리 - 게시글 번호
	 * @throws Exception 
	 */
	@GetMapping("board/readPage")
	public String readPage(
			// model.addAttribute(cri);
			@ModelAttribute("cri") Criteria cri, 
			int bno,
			Model model,
			HttpSession session) throws Exception {
		/*
		// readPage로 session에 등록된 result message가 존재하는지 확인
		String result = (String)session.getAttribute("result");
		if(result != null) {
			model.addAttribute("result",result);
			session.removeAttribute("result");
		}
		*/
		
		// 조회수 증가
		bs.updateCnt(bno);
		
		// 상세보기 요청 게시글 정보
		BoardVO vo = bs.read(bno);
		model.addAttribute("boardVO",vo);
		model.addAttribute(cri);
		return "/board/read";
	}

	/**
	 * 게시글 수정 페이지 요청
	 * - 게시글 수정 화면 출력 
	 */
	@GetMapping("board/modify")
	public void modifyGet(int bno, Model model) throws Exception{
		BoardVO vo = bs.read(bno);
		model.addAttribute(vo); // boardVO
	}

	/**
	 * 게시글 수정 처리 요청
	 * 게시글 수정 완료 후 redirect - 수정게시글 상세보기 페이지 이동
	 */
	@PostMapping("board/modify")
	public String modifyPost(
			// HttpSession session, 
			RedirectAttributes rttrs,
			BoardVO board,Model model) throws Exception{
		String result = bs.modify(board);
		// session.setAttribute("result",result);
		rttrs.addFlashAttribute("result",result);
		rttrs.addAttribute("bno", board.getBno());
		return "redirect:/board/readPage"; //+"?bno="+board.getBno();
	}

	/**
	 * 게시글 삭제 완료 후 listPage 페이지 로 이동 - redirect 
	 */
	 @GetMapping("board/remove")
	 public String remove(RedirectAttributes rttr, int bno) throws Exception{
		 String result = bs.remove(0);
		 rttr.addFlashAttribute("result",result);
		 return "redirect:/board/listPage";
	 }
	
	/**
	 *  페이징 처리 된 게시글 출력 페이지
	 *  param : 요청 page, perPageNum 
	 */
	// board/listPage
	@GetMapping("board/listPage")
	public void listPage(Criteria cri, Model model) throws Exception{
		System.out.println("listPage criteria : " + cri);
		List<BoardVO> list = bs.listCriteria(cri);
		model.addAttribute("list",list);
		
		PageMaker pm = bs.getPageMaker(cri);
		model.addAttribute("pm",pm);
	}
	
}
