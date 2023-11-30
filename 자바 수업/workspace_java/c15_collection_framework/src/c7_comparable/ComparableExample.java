package c7_comparable;

import java.util.TreeSet;

public class ComparableExample {

	public static void main(String[] args) {
		TreeSet<Integer> intSet = new TreeSet<>();
		intSet.add(50);
		intSet.add(70);
		intSet.add(60);
		intSet.add(50);
		System.out.println(intSet);
		
		System.out.println("===================================");
		TreeSet<Person> set = new TreeSet<>();
		set.add(new Person("최기근",26));
		System.out.println("--------------------------------");
		set.add(new Person("박진성",30));
		System.out.println("--------------------------------");
		set.add(new Person("송상엽",65));
		System.out.println("--------------------------------");
		set.add(new Person("엄수연",28));
		System.out.println("--------------------------------");
		System.out.println(set);
	}

}















