package i_arrays;

import java.util.Arrays;

public class ArrayEqualsExample {

	public static void main(String[] args) {
		
		int[][] original = {
				{1,2},{3,4}
		};
		
		System.out.println("== 얕은 복제 ==");
		int[][] copy = Arrays.copyOf(original, original.length);
		System.out.println(original.equals(copy));
		original[0][0] = 10;
		System.out.println(Arrays.toString(original));
		System.out.println(Arrays.toString(original[0]));
		System.out.println(Arrays.toString(copy));
		System.out.println(Arrays.toString(copy[0]));
		System.out.println(Arrays.equals(original, copy));
		
		System.out.println("== 깊은 복제==");
		copy[0] = Arrays.copyOf(original[0], original[0].length);
		copy[1] = Arrays.copyOf(original[1], original[1].length);
		System.out.println(Arrays.deepToString(original));
		System.out.println(Arrays.deepToString(copy));
		System.out.println(Arrays.deepEquals(original, copy));
		copy[0][1] = 30;
		System.out.println(Arrays.toString(original));
		System.out.println(Arrays.toString(copy));
		System.out.println(Arrays.deepToString(original));
		System.out.println(Arrays.deepToString(copy));
		System.out.println(Arrays.deepEquals(original, copy));
	}

}
