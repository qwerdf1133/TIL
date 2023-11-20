package interface_base;

public class RemoteControlExam {
	
	public static void main(String[] args) {
		
		RemoteControl airRemote; // = new RemoteCotrol();
		airRemote = new AirRemoteController();
		
		System.out.println(RemoteControl.MAX_VALUE);
		System.out.println(RemoteControl.MIN_VALUE);
		airRemote.turnOn();
		airRemote.setValue(11);
		airRemote.turnOff();
		
		// RemoteControl.MIN_VALUE = 30;
		RemoteControl rc = new TVRemoteControl();
		rc.turnOn();
		rc.setValue(20);
		rc.turnOff();
		
		RemoteControl smartRemote = new SmartTVRemoteControl();
		smartRemote.turnOn();
		smartRemote.setValue(10);
		smartRemote.turnOff();
		// smartRemote.search("슬램덩크");
		Searchable searchRemote = (Searchable)smartRemote;
		searchRemote.search("슬램덩크");
		
		if(searchRemote instanceof SmartTVRemoteControl) {
			SmartTVRemoteControl stc = (SmartTVRemoteControl)searchRemote;
			stc.turnOn();
			stc.setChannel(800);
			stc.turnOff();
		}
		
	}

}
