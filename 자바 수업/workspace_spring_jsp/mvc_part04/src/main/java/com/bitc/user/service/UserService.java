package com.bitc.user.service;

import org.springframework.stereotype.Service;

import com.bitc.user.mapper.UserMapper;
import com.bitc.user.vo.UserVO;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {
	
	private final UserMapper mapper;

	public void signUp(UserVO vo) throws Exception{
		mapper.signUp(vo);
	}

}












