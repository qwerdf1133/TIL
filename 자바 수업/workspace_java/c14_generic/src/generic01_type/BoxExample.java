package generic01_type;

public class BoxExample {

	public static void main(String[] args) {
		Box box1 = new Box();
		Apple apple = new Apple();
		// box1.obj = apple;
		box1.setObj(apple);
		
		Box box2 = new Box();
		Mango mango = new Mango();
		box2.setObj(mango);
		
		if(box1.getObj() instanceof Apple) {
			Apple app = (Apple) box1.getObj();
			System.out.println("사과가 들어있습니다");
		}
		
		// ShowBox
		// generic은 참조 타입만 지정 가능
		// ShowBox<int> box = new ShowBox<>(int);
		ShowBox<Apple> appleBox = new ShowBox<Apple>();
		// appleBox.setFruit(mango);
		appleBox.setFruit(apple);
		
		Apple apple1 = appleBox.getFruit();
		
		ShowBox<Mango> mangoBox = new ShowBox<>();
		mangoBox.setFruit(mango);
		Mango mango1 = mangoBox.getFruit();
		
		ShowBox<Apple[]> boxs = new ShowBox<>();
		boxs.setFruit(new Apple[] {apple, apple1});
		
		Apple[] apples = boxs.getFruit();
	}

}
