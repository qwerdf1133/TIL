package com.bitc.db_test.dao;

import java.util.List;

import com.bitc.db_test.vo.MemberVO;

public interface MemberDAO {
	
	/**
	 * @param member - ��ϵ� ȸ�� ����
	 * @return - ���Ե� ȸ�� �� ����
	 */
	int insertMember(MemberVO member);
	
	/**
	 * @param userid - �˻��� ȸ�� ���̵�
	 * @return - ���̵� ��ġ�ϴ� ȸ�� ����
	 */
	MemberVO readMember(String userid);
	
	/**
	 * @param userid - �˻��� ����� ���̵�
	 * @param userpw - �˻��� ����� ��й�ȣ
	 * @return - ���̵�� �н����尡 ��ġ�ϴ� ����� ���� - ������ null
	 */
	MemberVO readMemberWithPass(String userid, String userpw);
	
	/**
	 * @return - ��ü ȸ�� ���
	 */
	List<MemberVO> readMemberList();
	
	/**
	 * @param member - ������ ȸ�� ����
	 * @return	- ������ ���� ����
	 */
	int updateMember(MemberVO member);

	/**
	 * @param uno - ������ ȸ�� ��ȣ
	 * @return - ������ ���� ����
	 */
	int removeMember(int uno);
	
}