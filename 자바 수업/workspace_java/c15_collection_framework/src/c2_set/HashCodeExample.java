package c2_set;

import java.util.HashSet;
import java.util.Set;

public class HashCodeExample {

	public static void main(String[] args) {
		String name1 = "최기근";
		String name2 = "최기근";
		String name3 = new String("최기근");
		System.out.println(name1 == name3);
		System.out.println(name1.hashCode());
		System.out.println(name2.hashCode());
		System.out.println(name3.hashCode());
		
		Member member1 = new Member(name1, 20);
		Member member2 = new Member(name2, 26);
		Member member3 = new Member(name3, 20);
		Member member4 = new Member("최기근", 23);
		
		Set<Member> setMember = new HashSet<>();	// java.util
		setMember.add(member1);
		setMember.add(member2);
		setMember.add(member3);
		setMember.add(member4);
		System.out.println(setMember.size());
		System.out.println(setMember);

	}

}
