
public class Sec03_23_IfElse {

	public static void main(String[] args) {
		
		int[] arr2 = { 1, 2, 4, 5, 6, 7, 8, 9, 112, 444 , 687 };

		// Print only number which are multiple of 2;
		for (int i = 0; i < arr2.length; i++) {
			if (arr2[i] % 2 == 0) {
				System.out.println(arr2[i]);
			}
		}

	}

}
