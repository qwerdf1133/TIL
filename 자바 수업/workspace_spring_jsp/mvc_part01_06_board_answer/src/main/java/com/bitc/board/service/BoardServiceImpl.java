package com.bitc.board.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.bitc.board.dao.BoardDAO;
import com.bitc.board.util.Criteria;
import com.bitc.board.util.PageMaker;
import com.bitc.board.vo.BoardVO;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService {
	
	private final BoardDAO dao;

	@Override
	public String regist(BoardVO board) throws Exception {
		int result = dao.create(board);
		String message = (result != 0) ? "SUCCESS" : "FAILED";
		return message;
	}

	@Override
	public void updateCnt(int bno) throws Exception {
		dao.updateCnt(bno);
	}

	@Override
	public BoardVO read(int bno) throws Exception {
		return dao.read(bno);
	}

	@Override
	public List<BoardVO> listAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String modify(BoardVO board) throws Exception {
		return dao.update(board) != 0 ? "SUCCESS" : "FAILED";
	}

	@Override
	public String remove(int bno) throws Exception {
		return dao.delete(bno) == 1 ? "SUCCESS" : "FAILED";
	}

	@Override
	public List<BoardVO> listCriteria(Criteria cri) throws Exception {
		// database 에서 criteria 정보를 이용하여 사용자가 요청한 페이지에
		// 따라 게시글 목록을 검색하여 전달
		return dao.listCriteria(cri);
	}

	@Override
	public PageMaker getPageMaker(Criteria cri) throws Exception {
		// criteria 요청한 페이지 정보에 따라 페이징 블럭 정보를 저장하는
		// PageMaker 객체 생성 및 반환
		int totalCount = dao.totalCount();
		PageMaker pm = new PageMaker(cri,totalCount);
		return pm;
	}

}
