package guide_answer.practice02;

/**
 * 국가별 수도 정보를 저장할 class
 */
public class Nation {
	
	/**
	 * 국가 이름
	 */
	private String country;
	
	/**
	 * 수도 이름
	 */
	private String capital;	
	
	
	public Nation(String country, String capital) {
		this.country = country;
		this.capital = capital;
	}
	
	public String getCountry() {
		return country;
	}

	public String getCapital() {
		return capital;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Nation) {
			Nation n = (Nation)obj;
			// 저장된 국가 이름이 동일하면 동등한 객체로 확인하도록 재정의
			if(this.country.equals(n.getCountry())) {
				return true;
			}
		}
		return false;
	}
	
}






