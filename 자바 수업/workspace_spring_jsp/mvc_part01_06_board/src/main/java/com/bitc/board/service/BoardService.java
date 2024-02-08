package com.bitc.board.service;

import java.util.List;

import com.bitc.board.util.Criteria;
import com.bitc.board.util.PageMaker;
import com.bitc.board.vo.BoardVO;

public interface BoardService{
	
	/**
	 * 게시글 작성 - 성공 유무에 따라 메세지 전달
	 * @param 게시글 등록 정보
	 * @return 성공 유무 메세지
	 */
	String regist(BoardVO board)throws Exception;
	
	/**
	 * 조회수 증가
	 * @param bno 조회수 증가 시킬 게시글 번호 
	 */
	void updateCnt(int bno)throws Exception;
	
	/**
	 * 게시글 상세보기
	 * @param bno - 상세보기 게시글 번호
	 * @return 조회된 게시글 정보
	 */
	BoardVO read(int bno) throws Exception;
	
	/**
	 * 게시글 전체 목록 페이지
	 * @return 전체 게시글 목록을 리스트로 반환
	 */
	List<BoardVO> listAll() throws Exception;
	
	/**
	 * 게시글 수정 - 성공 유무에 따라 메세지 전달
	 * @param board - 수정할 게시글 정보
	 * @return - 수정 작업 완료 여부를 메시지로 반환
	 */
	String modify(BoardVO board) throws Exception;
	
	/**
	 * 게시글 삭제 - 성공 유무에 따라 메세지 전달
	 * @param bno - 삭제할 게시글 번호
	 * @return - 삭제 완료 여부를 메세지로 반환
	 */
	String remove(int bno) throws Exception;
	
	/**
	 * 페이징 처리된 리스트 목록
	 * @param cri - 페이징 처리된 게시글 목록을 불러올 정보 <br/>
	 * 				page 요청 페이지    <br/> 
	 * 				startrow(검색 시작 행 인덱시 번호)	<br/>
	 * 				perPageNum(검색할 게시글 개수) 	<br/>
	 * @return - 페이징 처리된 게시글 목록을 리스트로 반환
	 */
	List<BoardVO> listCriteria(Criteria cri)throws Exception;
	
	/**
	 * 페이징 정보 처리
	 * @param cri - 페이징 처리에 필요한 정보
	 * @return	페이징 블럭 출력을 위한 정보를 저장하는 PageMaker 객체 반환
	 */
	PageMaker getPageMaker(Criteria cri)throws Exception;

	
}











