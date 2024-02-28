package com.bitc.user.mapper;

import org.apache.ibatis.annotations.Insert;

import com.bitc.user.vo.UserVO;

public interface UserMapper {
	
	/**
	 * @param vo - 회원가입에 필요한 회원 정보
	 *  uid, upw, uname
	 */
	@Insert("INSERT INTO tbl_user(uid, upw, uname) "
			+ "VALUES(#{uid}, #{upw}, #{uname})")
	void signUp(UserVO vo)throws Exception;
	
	

}










