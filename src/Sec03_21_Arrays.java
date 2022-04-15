import java.util.ArrayList;

public class Sec03_21_Arrays {

	public static void main(String[] args) {

		// first way for interger array
		int[] arr = new int[5];
		for (int i = 0; i < 5; i++) {
			arr[i] = i;
		}

		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]);
		}
		System.out.println("\n");

		// second way for integer array
		int[] arr2 = { 1, 2, 4, 5, 6, 7, 8, 9, 112, 444 };
		for (int i = 0; i < arr2.length; i++) {
			System.out.println(arr2[i]);
		}

		// String array
		String[] name = { "as", "vfg", "fff", "fff" };
		for (int i = 0; i < name.length; i++) {
			System.out.println(name[i]);
		}
		System.out.println("\n");

		// Enhanced for loop
		for (String s : name)
			System.out.println(s);
		
		
		//ArrayList : here size is dynamic
		ArrayList<String> a = new ArrayList<String>();
		a.add("acf");
		a.add("a");
		a.add("cf");
		a.add("ac");
		System.out.println(a.get(1));
		
		
		
	}

}
