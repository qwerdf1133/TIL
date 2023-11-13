package GUIDE.member;

import java.util.Scanner;

public class MemberManagement{

	// 사용자 입력
	Scanner sc = new Scanner(System.in);
	
	// 회원정보 저장
	Member[] members = new Member[100];
	
	// 관리자 계정
	Member master = new Member(100,"master","root","root");
	
	// 로그인한 회원
	Member loginMember = null;
	
	// 프로그램 flag (true : 진행 , false : 종료) 
	boolean isRun = true;
	
	// 메뉴 번호 선택
	int selectNo;

	// 프로그램 실행용 생성자
	MemberManagement() {
		// 회원목록 배열 마지막 인덱스에 관리자 계정 저장
		members[members.length-1] = master;
		// 회원관리 메소드 호출
		isRun();
	}
	
	/*
	 * 기능 관리 
	 */
	
	// 프로그램 실행
	void isRun() {
		
	}
	
	// 프로그램 종료
	void terminate() {
		
	}

	// 회원 가입
	void join() {
		
	}
	
	// 로그인
	void login() {
		
	}

	// 회원목록 - 로그인한 회원이 관리자 일때만 노출 
	void select() {
		
	}
	
	// 회원정보 수정 - 로그인한 회원 정보랑 일치 하거나 관리자 일때만 수정(이름정보만 수정)
	void update() {
		
	}
	
	// 회원탈퇴 - 삭제 할려는 정보가 본인 정보일때만 삭제
	void delete() {
		
	}
	
	// 사용자 아이디 중복 체크
	boolean memberIdCheck(String mId) {
		for(Member m : members) {
			if(m != null && m.mId.equals(mId)) {
				return false;
			}
		}		
		return true;
	}
	
	// 회원 아이디와 비밀번호로 회원 찾기
	Member findMember(Member m) {
		for(Member member : members) {
			if(member != null && member.equals(m)) {
				return member;
			}
		}
		return null;
	}
	
	// 회원 정보 삭제
	void deleteMember() {
		for(int i=0; i<members.length; i++) {
			if(members[i].equals(loginMember)) {
				members[i] = null;
				loginMember = null;
				System.out.println("회원탈퇴 완료");
				return;
			}
		}
	}
}
