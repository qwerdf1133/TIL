package com.bitc.db_test.dao;

import java.util.List;

import com.bitc.db_test.vo.MemberVO;

public interface MemberDAO {
	
	/**
	 * @param member - 등록될 회원 정보
	 * @return - 삽입된 회원 행 개수
	 */
	int insertMember(MemberVO member);
	
	/**
	 * @param userid - 검색할 회원 아이디
	 * @return - 아이디가 일치하는 회원 정보
	 */
	MemberVO readMember(String userid);
	
	/**
	 * @param userid - 검색할 사용자 아이디
	 * @param userpw - 검색할 사용자 비밀번호
	 * @return - 아이디와 패스워드가 일치하는 사용자 정보 - 없으면 null
	 */
	MemberVO readMemberWithPass(String userid, String userpw);
	
	/**
	 * @return - 전체 회원 목록
	 */
	List<MemberVO> readMemberList();
	
	/**
	 * @param member - 수정할 회원 정보
	 * @return	- 수정한 행의 개수
	 */
	int updateMember(MemberVO member);

	/**
	 * @param uno - 삭제할 회원 번호
	 * @return - 삭제한 행의 개수
	 */
	int removeMember(int uno);
	
}