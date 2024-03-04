package com.bitc.user.vo;

import lombok.Data;

/**
 * DTO(Data Transfer Object) 계층간의 데이터 교환을 위한 객체
 * VO(Value Object) - 데이터를 저장하기 위한 객체이나 read-only 성향이 강함.
 */
@Data
public class LoginDTO {
	
	private String uid;
	private String upw;
	private boolean userCookie;

}
