package com.bitc.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bitc.mapper.MessageMapper;
import com.bitc.mapper.UserMapper;
import com.bitc.vo.MessageVO;
import com.bitc.vo.UserVO;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class MessageServiceImpl implements MessageService {

	private final MessageMapper mapper;
	private final UserMapper userMapper;

	@Transactional
	@Override
	public void addMessage(MessageVO vo) throws Exception {
		log.info("addMessage Service 시작");
		// 발신자 포인트 증가 + 10
		UserVO uv = new UserVO();
		uv.setUid(vo.getSender());
		uv.setUpoint(10);
		userMapper.updatePoint(uv);

		// 메세지 등록
		mapper.create(vo);
		log.info("addMessage Service 종료");
	}

	@Override
	public List<MessageVO> list() throws Exception {
		log.info("MessageService list 호출--------------");
		return mapper.list();
	}

	@Transactional
	@Override
	public MessageVO readMessage(String uid, int mno) throws Exception {
		// 메세지 번호로 하나의 메세지 정보 읽기
		/*
		MessageVO message = mapper.readMessage(mno);
		if(message.getOpendate() != null) {
			// 이미 수신한 메세지
			throw new NullPointerException("이미 읽은 메세지 입니다.");
		}
		*/
		// update : opendate == now() 
		mapper.updateMessage(mno);
		
		// 수신자 포인트 증가 +5
		UserVO vo = new UserVO();
		vo.setUid(uid);
		vo.setUpoint(5);
		userMapper.updatePoint(vo);
		
		// opendate 수정 완료된 메세지 정보 반환
		return mapper.readMessage(mno);
	}

}











