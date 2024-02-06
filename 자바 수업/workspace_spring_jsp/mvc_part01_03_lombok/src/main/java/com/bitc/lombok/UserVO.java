package com.bitc.lombok;

import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import lombok.Singular;
import lombok.ToString;

// @Data
// @Getter
// @Setter
// 객체 생성 시에 필요한 필수 값이 존재 하기 때문에 기본 생성자로 객체 생성 불가
// @NoArgsConstructor						// 기본 생성자 추가
// @AllArgsConstructor						// 모든 값을 매개변수로 받는 생성자 추가
// @ToString(callSuper = true)				// 부모 toString도 호출
// @Tostring(exclude = "uid")				// toString에 해당 필드 제외
// @ToString(exclude = {"uid","upw"})		// 여러 필드 제외
// @ToString(of = {"uid","upw"})			// 지정한 필드만 포함
// @EqualsAndHashCode(of= {"uid","upw"})	// 저장된 필드 정보가 일치하면 논리적으로 동등한 객체
// @RequiredArgsConstructor
@Builder
@ToString 
public class UserVO {
	
	@Getter
	private int uno;
	@Setter @NonNull
	private String uid;
	@NonNull
	private String upw;
	private final String uname;
	
	@DateTimeFormat(pattern="yyyy-MM-dd hh:mm:ss")
	private Date regdate;
	
	@Singular("list")
	private List<String> friendList;

}