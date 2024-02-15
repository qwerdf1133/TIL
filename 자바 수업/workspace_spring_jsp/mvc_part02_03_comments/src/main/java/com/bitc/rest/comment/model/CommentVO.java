package com.bitc.rest.comment.model;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class CommentVO {
	
	private int cno;				// 댓글번호
	private int bno;				// 댓글이 등록된 게시글 번호
	private String content;			// 내용
	private String author;			// 작성자
	private Date regdate;			// 작성시간
	private Date updatedate;		// 수정시간

}











