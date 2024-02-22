package com.bitc.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.bitc.mapper.MessageMapper;
import com.bitc.vo.MessageVO;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class MessageServiceImpl implements MessageService {
	
	private final MessageMapper mapper;

	@Override
	public void addMessage(MessageVO vo) throws Exception {
		log.info("addMessage Service 시작");
		// 메세지 등록
		mapper.create(vo);
		log.info("addMessage Service 종료");
	}

	@Override
	public List<MessageVO> list() throws Exception {
		log.info("MessageService list 호출--------------");
		return mapper.list();
	}

	@Override
	public MessageVO readMessage(String uid, int mno) throws Exception {
		return null;
	}

}





