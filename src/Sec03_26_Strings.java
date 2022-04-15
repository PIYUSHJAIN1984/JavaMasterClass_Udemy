
public class Sec03_26_Strings {

	public static void main(String[] args) {

		// String in a object

		// First way : String literal
		String s = "abcd"; // here memory allocation is done for s variable so a object is created.
		String s1 = "abcd"; // here no new memory allocation done rather s1 points to s variable as value is
							// same. So, new object is not created

		// Second way: new keyword. here everytime new object is created even value is
		// same.
		String s2 = new String("Welcome");
		String s3 = new String("Welcome");

		// Split strings
		String s4 = "Rahul shetty academy";
		String[] splitString = s4.split(" ");
		System.out.println(splitString[1]);

		String[] splitString1 = s4.split("shetty");
		System.out.println(splitString1[0]);
		System.out.println(splitString1[1]);
		System.out.println(splitString1[1].trim());

		// Print string char by char
		for (int i = 0; i < s4.length(); i++)
			System.out.println(s4.charAt(i));

		System.out.println("\n");

		// Print characters of string in reverse order
		for (int i = s4.length() - 1; i > -1; i--) {
			System.out.println(s4.charAt(i));
		}

	}

}
