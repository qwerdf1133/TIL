package a_object.clone;

public class CloneExample {

	public static void main(String[] args) throws CloneNotSupportedException {
		
		Member member = new Member(
			"최기근", 26,
			new int[] {100,99,97},
			new Car("캐스퍼")
		);
		
		Member anotherMember = new Member();
		anotherMember.name = member.name;
		anotherMember.age = member.age;
		anotherMember.scores = member.scores;
		anotherMember.car = member.car;
		
		System.out.println(member);
		System.out.println(anotherMember);
		
		
		Member cloned = member.getCloned();
		System.out.println(cloned);
		cloned.name = "차승원";
		cloned.age = 41;
		cloned.scores[0] = 70;
		cloned.car.model = "그랜져";
		System.out.println("==============================");
		System.out.println(member);
		System.out.println(cloned);

	}

}


























