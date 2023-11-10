package c_method;

// 탁상용 램프
public class DarkLamp {
	
	// 인스턴스의 멤버 변수 - field 정의
	// 켜짐이나 꺼짐과 같은 램프의 상태를 저장
	boolean isOnOff;
	
	// 램프를 켠다
	void turnOn() {
		isOnOff = true;
	}
	
	// 램프를 끈다.
	void turnOff() {
		isOnOff = false;
	}
}
