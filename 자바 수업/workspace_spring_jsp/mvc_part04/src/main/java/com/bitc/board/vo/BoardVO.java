package com.bitc.board.vo;

import java.util.Date;
import java.util.List;

import lombok.Data;
/**
 * 질문과 답변형 게시글 정보를 저장할 class
 */
@Data
public class BoardVO {
	
	private int bno;
	private String title;
	private String content;
	private String writer;
	private int origin;
	private int depth;
	private int seq;
	private Date regdate;
	private Date updatedate;
	private int viewcnt;
	private String showboard;
	private  int uno;
	
	// 첨부된 파일 이름 리스트
	private List<String> files;

}












