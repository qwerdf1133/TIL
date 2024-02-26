package com.bitc.mapper;

import org.apache.ibatis.annotations.Update;

import com.bitc.vo.UserVO;

/**
 * tbl_user table 작업 수행 class
 */
public interface UserMapper {

	/**
	 * @param vo - 추가할 포인트 점수 & 수정할 사용자 uid
	 */
	@Update("UPDATE tbl_user SET upoint = upoint + #{upoint} " + " WHERE uid = #{uid}")
	void updatePoint(UserVO vo) throws Exception;

}
