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
}
