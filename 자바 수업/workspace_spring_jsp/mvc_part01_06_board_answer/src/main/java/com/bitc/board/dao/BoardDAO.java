package com.bitc.board.dao;

import java.util.List;

import com.bitc.board.util.Criteria;
import com.bitc.board.vo.BoardVO;

public interface BoardDAO{
	
	/**
	 * 게시글 작성
	 * @param BoardVO db에 등록할 게시글 정보
	 * @return 등록된 게시글 개수를 수로 반환
	 */
	int create(BoardVO vo) throws Exception;
	
	/**
	 * 게시글 상세보기
	 * @param bno - 상세보기할 게시글 번호
	 * @return - 조회된 게시글 정보를 BoardVO 타입으로 반환
	 */
	BoardVO read(int bno)throws Exception;
	
	/**
	 * 게시글 수정
	 * @param BoardVO 수정할 게시글 정보
	 * @return - 수정된 게시글 개수를 정수로 반환
	 */
	int update(BoardVO vo) throws Exception;
	
	/**
	 * 게시글 삭제
	 * @param bno - 삭제할 게시글 번호
	 * @return - 삭제된 게시글 개수를 정수로 반환
	 */
	int delete(int bno) throws Exception;
	
	/**
	 * 조회수 증가
	 * @param bno - 조회수 증가 시킬 게시글 번호
	 */
	void updateCnt(int bno) throws Exception;
	
	/**
	 * 전체 게시글 목록
	 * @return - 조회된 전체 게시글 목록
	 */
	List<BoardVO> listAll()throws Exception;

	/**
	 * 전체 게시물 개수
	 * @return - 전체 게시글 개수
	 */
	int totalCount() throws Exception;
	
	/**
	 * 페이징 처리된 게시물 목록
	 * @param cri - 페이징 된 게시글 목록을 조회할 정보
	 * @return - 조회된 게시글 목록
	 */
	List<BoardVO> listCriteria(Criteria cri)throws Exception;
	
}











