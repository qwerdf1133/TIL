package f_object_array;

public class KoreanExample {
	
	public static void main(String[] args) {
		
		Korean[] koreans = new Korean[3];
		//    0 	 1 	 	2
		// [null] [null] [null]
		System.out.println(koreans);
		for(int i = 0; i < koreans.length; i++){
			System.out.println(i+":"+koreans[i]);
		}
		
		Korean k1 = new Korean();
		// [k1] [null] [null]
		koreans[0] = k1;
		k1.name = "최기근";
		k1.birth = "820607";
		k1.age = 26;
		System.out.println(koreans[0].name);
		System.out.println(koreans[0].birth);
		System.out.println(koreans[0].age);
		
		koreans[1] = new Korean();
		// [k1] [Korean] [null]
		koreans[1].name = "이순신";
		koreans[1].birth = "1678";
		koreans[1].age = 356;
		
		for(Korean k : koreans) {
			if(k != null) {
				System.out.println(k.nation);
				System.out.println(k.name);
				System.out.println(k.birth);
				System.out.println(k.age);
				System.out.println("===================");
			}
		}
	}
}
