package guide_answer.member;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

 
/**
 * 회원 관리에 대한 전반적인 내용의 정의한다.
 */
public abstract class AppBase {

	/**
	 * 사용자 입력
	 */
	protected Scanner sc;

	/**
	 * 회원 목록 정보 저장할 리스트
	 */
	protected ArrayList<Member> memberList;

	/**
	 * 관리자 계정 -> Member 객체에 reg(회원가입일 추가 됨)
	 */
	protected Member master;

	/**
	 * 로그인한 회원 정보를 저장할 필드
	 */
	protected Member loginMember;

	/**
	 * 프로그램 flag (true : 진행 , false : 종료)
	 */
	protected boolean isRun;

	/**
	 * 메뉴 선택 번호를 저장할 필드
	 */
	protected int selectNo;
	
	/**
	 * 등록할 회원번호를 저장할 필드
	 * 마스터를 0번으로 1씩 증가하는 회원번호를 저장하고 부여한다.
	 */
	protected int number;

	/**
	 * 프로그램 실행용 생성자
	 */
	protected AppBase() {
		sc = new Scanner(System.in);
		memberList = new ArrayList<>();
		// master 등록 정보를 참고하여 회원 정보 등록 
		master = new Member(number, "master", "root", "root", System.currentTimeMillis());
		memberList.add(master);
		number++;
		isRun = true;
		isRun();
	}

	/**
	 * 기능 관리
	 */
	
	/**
	 * 프로그램 실행 - 메뉴 정보별 기능 수행 Method
	 */
	protected void isRun() {
		while(isRun) {
			System.out.println("===================================================");
			System.out.println("1.회원가입|2.로그인|3.회원정보|4.회원정보수정|5.회원탈퇴|6.종료");
			System.out.println("===================================================");
			
			selectNo = getNumberData("메뉴 선택 >");
			
			switch(selectNo) {
			case 1 : 
				System.out.println("== 회원가입 == ");
				join();
				break;
			case 2 : 
				System.out.println("== 로그인 == ");
				login();
				break;
			case 3 : 
				System.out.println("== 회원정보 == ");
				select();
				break;
			case 4 : 
				System.out.println("== 회원 정보 수정 == ");
				update();
				break;
			case 5 : 
				System.out.println("== 회원탈퇴 == ");
				delete();
				break;
			case 6 : 
				System.out.println("== 프로그램 종료 == ");
				terminate();
				break;
			default :
				System.out.println("해당 메뉴가 존재하지 않습니다.");
			}
			
		}
	}

	/**
	 * 프로그램 종료
	 */
	protected abstract void terminate();

	/**
	 * 회원 가입 - 회원정보를 입력받아 회원목록 배열에 저장
	 */
	protected abstract void join();

	/**
	 * 로그인 - 회원 목록에서 일치하는 회원을 찾아 loginMember Field에 저장
	 */
	protected abstract void login();

	/**
	 * 회원목록 - 로그인한 회원이 관리자 일때만 노출
	 */
	protected abstract void select();

	/**
	 * 회원정보 수정 - 로그인한 회원 정보랑 일치 하거나 관리자 일때만 수정(이름정보만 수정)
	 */
	protected abstract void update();

	/**
	 * 회원탈퇴 - 삭제 할려는 정보가 본인 정보일때만 삭제
	 * loginMember Field 활용
	 */
	protected abstract void delete();

	/**
	 * 회원 정보 삭제
	 * members 배열에서 현재 로그인된 회원 정보를 제거
	 */
	protected abstract void deleteMember();

	/**
	 * 사용자 아이디 중복 체크
	 * @param mId
	 * @return 사용가능 여부
	 */
	protected boolean memberIdCheck(String mId) {
		for (Member m : memberList) {
			if (Objects.nonNull(m) && Objects.equals(mId,m.getmId())) {
				return false;
			}
		}
		return true;
	}

	/**
	 * 회원 아이디와 비밀번호로 회원 찾기
	 * @param 아이디와 패스워드가 저장된 Member 객체
	 * @return 검색 완료된 회원 정보
	 */
	protected Member findMember(Member m) {
		for (Member member : memberList) {
			if (Objects.equals(m, member)) {
				return member;
			}
		}
		return null;
	}

	protected String getStringData(String message) {
		System.out.println(message);
		return sc.next();
	}

	protected int getNumberData(String message) {
		System.out.println(message);
		if (!sc.hasNextInt()) {
			System.out.println("사용할 수 없는 값입니다.");
			sc.next();
			return 0;
		}
		return sc.nextInt();
	}
}
