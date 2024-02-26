package com.bitc.service;

import java.util.List;

import com.bitc.vo.MessageVO;

public interface MessageService {

	/**
	 * @param vo - 등록할 메세지 정보 targetid : 수신자 id <br/>
	 *           sender : 발신자 id <br/>
	 *           message : 전달할 메세지 <br/>
	 *           message 정보를 table에 추가 한 후 발신한 사용자의 upoint를 10점 부여
	 */
	void addMessage(MessageVO vo) throws Exception;

	/**
	 * @return - 등록된 전체 메세지 목록
	 */
	List<MessageVO> list() throws Exception;

	/**
	 * @param uid - 수신자 id
	 * @param mno - 수신학인할 메세지 번호
	 * @return - 수신된 메세지 정보(opendate 확인 시간 포함) 수신확인 시간으로 tbl_message 행 정보 수정 후 수정
	 *         완료된 메세지 정보를 반환 수신확인한 사용자의 upoint 정보를 5점 부여
	 */
	MessageVO readMessage(String uid, int mno) throws Exception;

}
