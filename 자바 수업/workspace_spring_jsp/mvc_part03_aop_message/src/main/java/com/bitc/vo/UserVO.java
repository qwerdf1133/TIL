package com.bitc.vo;

import lombok.Data;

/**
 * tbl_user table의 회원별 행 정보를 저장할 class
 */
@Data
public class UserVO {
	private int uno;
	private String uid;
	private String upw;
	private String uname;
	private int upoint;
}
