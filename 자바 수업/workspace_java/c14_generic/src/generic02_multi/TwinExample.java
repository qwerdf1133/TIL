package generic02_multi;

public class TwinExample {

	public static void main(String[] args) {
		/*
		// 제네릭 타입을 명시하지 않으면 Object type가 된다.
		Twin<Car, Tv> twin = new Twin<Car, Tv>();
		twin.setKind(new Car());
		twin.setModel(new Tv());
		*/
		Twin<Tv,String> tvTwin = new Twin<>();
		Tv tv = new Tv();
		tvTwin.setKind(tv);
		tvTwin.setModel("LG 스마트TV");
		
		Twin<Car, Integer> car = new Twin<Car, Integer>();
		car.setKind(new Car());
		car.setModel(520);
		System.out.println(car);
		
	}

}
