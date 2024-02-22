package com.bitc.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.bitc.vo.MessageVO;

public interface MessageMapper {

	/**
	 * message 등록
	 * @param vo - 등록할 메세지 정보
	 */
	@Insert("INSERT INTO tbl_message(targetid,sender,message) "
			+ " VALUES(#{targetid},#{sender},#{message})")
	void create(MessageVO vo)throws Exception;
	
	/**
	 * @param mno - 수신 확인할 메세지 번호
	 * 사용자가 메세지 수신 확인하면 opendate column 정보를
	 * 수신확인한 시간으로 수정
	 */
	@Update("UPDATE tbl_message SET opendate = now() WHERE mno = #{mno}")
	void updateMessage(int mno) throws Exception;

	/**
	 * @param mno - 확인할 메세지 번호
	 * @return - mno가 일치하는 하나의 메세지 정보 반환
	 */
	@Select("SELECT * FROM tbl_message WHERE mno = #{mno}")
	MessageVO readMessage(int mno)throws Exception;
	
	/**
	 * @return - 테이블에 등록된 전체 메세지 목록
	 */
	@Select("SELECT * FROM tbl_message ORDER BY mno DESC")
	List<MessageVO> list() throws Exception;
}











