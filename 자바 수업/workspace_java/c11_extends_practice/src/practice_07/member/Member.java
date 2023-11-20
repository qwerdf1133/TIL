package practice_07.member;


public class Member {
	
	// 회원관리번호
	private int mNum;
	// 회원 이름
	private String mName;
	// 회원 아이디
	private String mId;
	// 회원 비밀번호
	private String mPw;
	
	public Member() {}

	// 회원 로그인 및 정보 검색용 생성자
	public Member(String mId, String mPw) {
		setmId(mId);
		setmPw(mPw);
	}

	// 회원가입 용
	public Member(int mNum, String mName, String mId, String mPw) {
		this(mId, mPw);
		setmNum(mNum);
		setmName(mName);
	}
	
	public int getmNum() {
		return mNum;
	}

	public void setmNum(int mNum) {
		if(mNum < 1){
			System.out.println("회원 번호는 1보다 작을 수 없습니다.");
			return;
		}
		this.mNum = mNum;
	}

	public String getmName() {
		return mName;
	}

	public void setmName(String mName) {
		if(mName == null || mName.equals("")) {
			System.out.println("정상적인 이름이 아닙니다.");
			return;
		}
		this.mName = mName;
	}

	public String getmId() {
		return mId;
	}

	public void setmId(String mId) {
		if(mId == null || mId.equals("")) {
			System.out.println("정상적인 id가 아닙니다.");
			return;
		}
		this.mId = mId;
	}

	public String getmPw() {
		return mPw;
	}

	public void setmPw(String mPw) {
		if(mPw == null || mPw.equals("")) {
			System.out.println("정상적인 비밀번호가 아닙니다.");
			return;
		}
		this.mPw = mPw;
	}
	
	public boolean equals(Member member) {
		if(member == null) return false;
		if(this.mId.equals(member.getmId()) && this.mPw.equals(member.getmPw())) {
			return true;
		}
		return false;
	}

	public String toString() {
		return "Member{ [mNum : "+this.mNum+"] [mName : " +this.mName +"] [ mId : " + this.mId+"]";
	}

}
