package generic04_extends;

public class Example {
	
	public static void main(String[] args) {
		Parent<String, String> p1 = new Parent<>();
		p1.setKind("TV");
		p1.setModel("ES-DES1");
		System.out.println(p1);
		
		Parent<String, String> child = new Child<>();
		child.setKind("Car");
		child.setModel("S Class");
		System.out.println(child);
		
		Child<Integer,String,String> childs = (Child<Integer,String,String>)child;
		childs.setCompany(502);
		int a = childs.getCompany();
		System.out.println(a);
		System.out.println(childs);
				
		System.out.println("======================");
		Storage<Integer> storage = new StorageImpl<>(5);
		// storage.add("", 0);
		storage.add(100, 0);
		System.out.println(storage.get(0));
		
	}

}
