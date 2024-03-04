package com.bitc.user.service;

import org.springframework.stereotype.Service;

import com.bitc.user.mapper.UserMapper;
import com.bitc.user.vo.LoginDTO;
import com.bitc.user.vo.UserVO;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {
	
	private final UserMapper mapper;
	
	/**
	 * @param vo - 회원 가입 요청 처리
	 */
	public void signUp(UserVO vo) throws Exception{
		mapper.signUp(vo);
	}

	/**
	 * 
	 * @param dto - 로그인 요청 처리에 필요한 정보를 저장하는 객체
	 * @return - 로그인 으로 인증이 완료된 사용자 정보를 UserVO 객체에 저장하여 반환
	 */
	public UserVO signIn(LoginDTO dto) throws Exception{
		return mapper.sigIn(dto);
	}

}












