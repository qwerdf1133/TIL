package abstract_base;

public class Zoo {
	
	static void animalSound(Animal animal) {
		animal.breath();
		animal.sound();
	}

	public static void main(String[] args) {
		// 실체화 되지 않은 기능을 가지고 있는 추상클래스는
		// 추상클래스만으로 객체 생성이 불가.
		// Animal animal = new Animal();
		
		Dog dog = new Dog();
		dog.breath();
		dog.kind = "Jindo";
		dog.sound();
		
		Cat cat = new Cat();
		cat.kind = "Siamese Cat"; // 샴고양이
		cat.breath();
		cat.sound();
		
		animalSound(dog);
		animalSound(cat);
		
		Animal navi = new Cat();
		navi.kind = "시거르자브르종";
		animalSound(navi);
		
		
		// 익명 구현 객체
		Animal tiger = new Animal() {
			
			String name;
			
			public void sound() {
				System.out.println(name + " : 어흥");
			}
		};
		
		// tiger.name = "얼룩이";
		tiger.kind = "호랑이";
		animalSound(tiger);
		
	}

}
