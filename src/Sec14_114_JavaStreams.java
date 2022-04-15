import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Sec14_114_JavaStreams {

	@Test
	public void getOutput() {
		// Count number of names starting with alphabet A in list

		ArrayList<String> names = new ArrayList<String>();
		names.add("Avd");
		names.add("Vfff");
		names.add("Asddd");
		names.add("Bgggg");
		names.add("Aerty");

		int count = 0;
		for (String name : names) {
			if (name.startsWith("A"))
				count++;
		}
		System.out.println(count);
	}

	@Test
	public void streamFilter() {

		// *********** Count number of names starting with alphabet A in
		// list************//
		// Scenario1 : Create a collection of arraylist and converting into stream
		ArrayList<String> names = new ArrayList<String>();
		names.add("Avd");
		names.add("Vfff");
		names.add("Asddd");
		names.add("Bgggg");
		names.add("Aerty");

		// ArrayList converted to stream using .stream
		// Here all collection is scan parallely
		// filter is intermediate operation
		// count is terminal operation applied on new collection of steam created from
		// inter.. operation
		Long a = names.stream().filter(s -> s.startsWith("A")).count();
		System.out.println(a);

		// Scenario2 : Create a stream directly to do filter operation
		// There is no life of intermediatery operation if there is no terminal op
		// terminal op will execute only if inter operation returns true
		long c = Stream.of("Avd", "Vfff", "Asddd", "Bgggg", "Aerty").filter(s -> s.startsWith("A")).count();
		System.out.println(c);

		// Scenario3 :Stream with multiple actions will be in '{' '}'
		long d = Stream.of("Avd", "Vfff", "Asddd", "Bgggg", "Aerty").filter(s -> {
			s.startsWith("A");
			return false;
		}).count();

		System.out.println(d);

		// *********** Print names which are more than 4 letters in list************//
		names.stream().filter(s -> s.length() > 4).forEach(s -> System.out.println(s));

		// *********** Print first name which is than 4 letters in list************//
		names.stream().filter(s -> s.length() > 4).limit(1).forEach(s -> System.out.println(s));

	}

	@Test
	public void streamMap() {
		ArrayList<String> names1 = new ArrayList<String>();
		names1.add("Avd1");
		names1.add("Vfff1");
		names1.add("Asddd1");
		names1.add("Bgggg1");
		names1.add("Aerty1");

		// *********** Print names which has last letter 'd' in list in uppser case
		Stream.of("Avd", "Vfff", "Asddd", "Bgggg", "Aerty").filter(s -> s.endsWith("d")).map(s -> s.toUpperCase())
				.forEach(s -> System.out.println(s));

		// *********** Print names which has first letter 'a' in list in upper case
		List<String> name = Arrays.asList("Avd", "Vfff", "Asddd", "Bgggg", "Aerty");
		name.stream().filter(s -> s.startsWith("A")).sorted().map(s -> s.toUpperCase())
				.forEach(s -> System.out.println(s));

		// **************Merge 2 array list******************************//
		// Stream once operated cannot be used again so line 94 is commented here
		Stream<String> newStream = Stream.concat(name.stream(), names1.stream());
		// newStream.sorted().forEach(s->System.out.println(s));

		// **************Returns boolean value if 'Vfff' present in merged
		// list******************************//
		boolean flag = newStream.anyMatch(s -> s.equalsIgnoreCase("vfff"));
		System.out.println(flag);
		Assert.assertTrue(flag);

	}

	@Test
	public void streamCollect() {
		//Convert Stream into list using collect method and print first element
		List<String> a = Stream.of("Avd", "Vfff", "Asddd", "Bgggg", "Aerty").filter(s -> s.endsWith("d")).map(s -> s.toUpperCase())
		.collect(Collectors.toList());
		System.out.println(a.get(0));
		
		//Convert Stream into list and then print first element without using Collect method
		Stream.of("Avd", "Vfff", "Asddd", "Bgggg", "Aerty").filter(s -> s.endsWith("d")).map(s -> s.toUpperCase())
				.limit(1).forEach(s->System.out.println(s));
		
		
		//Assignment : Print unique numbers from this array
		List<Integer> values = Arrays.asList(3,2,2,7,5,1,9,7);
		values.stream().distinct().forEach(s -> System.out.println(s));
		
		//Take the unique values in list and print 3rd index after sorting
		List<Integer> p = values.stream().distinct().sorted().collect(Collectors.toList());
		System.out.println(p.get(1));
		
			
		
	}
}
