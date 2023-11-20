package interface_base;

public class TVRemoteControl implements RemoteControl{
	
	int volume;

	@Override
	public void turnOff() {
		System.out.println("TV를 끕니다.");
	}

	@Override
	public void turnOn() {
		System.out.println("TV를 켭니다.");
	}

	@Override
	public void setValue(int value) {
		if(value <= MAX_VALUE && value >= MIN_VALUE) {
			this.volume = value;
			System.out.println(this.volume+"으로 음량을 설정합니다.");
		}else {
			System.out.println("변경할 수 없습니다.");
		}
	}

}
