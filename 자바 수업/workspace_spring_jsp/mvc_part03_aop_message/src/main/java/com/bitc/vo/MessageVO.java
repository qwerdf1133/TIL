package com.bitc.vo;

import java.util.Date;

import lombok.Data;

/**
 * tbl_message table의 행 정보를 저장할 class
 */
@Data
public class MessageVO {
	private int mno;
	private String targetid;
	private String sender;
	private String message;
	private Date opendate;
	private Date senddate;
}
