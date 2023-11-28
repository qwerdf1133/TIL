package generic.exam04;

public class Util {

	/*
		getValue() method 작성	
	*/
	
	public static <K, V> V getvalue(Pair<K,V> p, K k) {
		if(p.getKey().equals(k)) {
			return p.getValue();
		}
		
		return null;
	}

	public static Integer getvalue(ChildPair<String, Integer> childPair, String k) {
		return null;
	}
	
}
 