package com.example;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Exercise4 {

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		List<Integer> numbers = List.of(1,2,3,4,5,6,7,8,9,10);
		// Loop
		for (var i : numbers) { // outer loop
			System.out.println(i);
		}
		// Algorithms -> Collections -> out of the collection
		var mx = Collections.max(numbers);
		var mn = Collections.min(numbers);
		var sortedNumbers = numbers.toArray(new Integer[0]); 
		Arrays.parallelSort(sortedNumbers);
		
		// Multi-core Programming!
		// Thread, ThreadPool, synchronized, Fork/Join Framework, ...
		
		// Java 8+: Stream API -> Collection API
		// Loop
		numbers.forEach(System.out::println); // inner -> optimized! -- in the future --> GPU
		// Algorithms: Filter/Map/Reduce
		var sum = numbers.stream().parallel().filter(n -> n%2 == 0).mapToInt(u -> u*u).sum();
		mx = numbers.stream().max(Integer::compareTo).get(); // -- in the future --> GPU
		mn = numbers.stream().min(Integer::compareTo).get();
		// Multi-core Programming
		sum = numbers.stream().parallel().filter(n -> n%2 == 0).mapToInt(u -> u*u).sum();
		mn = numbers.stream().parallel().min(Integer::compareTo).get();
		
		
	}

}
