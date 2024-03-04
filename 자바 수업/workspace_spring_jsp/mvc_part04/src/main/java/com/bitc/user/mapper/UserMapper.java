package com.bitc.user.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import com.bitc.user.vo.LoginDTO;
import com.bitc.user.vo.UserVO;

public interface UserMapper {
	
	/**
	 * @param vo - 회원가입에 필요한 회원 정보
	 *  uid, upw, uname
	 */
	@Insert("INSERT INTO tbl_user(uid, upw, uname) "
			+ "VALUES(#{uid}, #{upw}, #{uname})")
	void signUp(UserVO vo)throws Exception;

	@Select("SELECT * FROM tbl_user WHERE uid = #{uid} AND upw = #{upw}")
	UserVO sigIn(LoginDTO dto) throws Exception;

	/**
	 * uid가 일치하는 사용자 정보 검색 
	 */
	@Select("SELECT * FROM tbl_user WHERE uid = #{uid}")
	UserVO getUserById(String uid) throws Exception;
	
	

}










