package object_array_guide.member;

public class Member {
	
	// 회원관리번호
	int mNum;
	// 회원 이름
	String mName;
	// 회원 아이디
	String mId;
	// 회원 비밀번호
	String mPw;
	
	
	Member() {}

	// 회원 로그인 및 정보 검색용 생성자
	Member(String mId, String mPw) {
		this.mId = mId;
		this.mPw = mPw;
	}

	// 회원가입 용
	Member(int mNum, String mName, String mId, String mPw) {
		this(mId,mPw);
		this.mNum = mNum;
		this.mName = mName;
	}
	
	boolean equals(Member member) {
		if(member == null) return false;
		if(this.mId.equals(member.mId) && this.mPw.equals(member.mPw)) {
			return true;
		}
		return false;
	}

	public String toString() {
		return "Member{ [mNum : "+this.mNum+"] [mName : " +this.mName +"] [ mId : " + this.mId+"]}";
	}

}
