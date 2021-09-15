package com.example;

import java.util.List;

public class Exercise2 {

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		int x = 42; // Stack: 4B
		Integer y= Integer.valueOf(549); // with Compressed Oops    -> Stack: reference (y) 4B + Heap: 12B + 4B = 20B
		                                 // without Compressed Oops -> 8B + 16B + 8B = 32B 
		Integer u = 42; //
		Integer v = 42;
		Integer m = 3615;
		Integer n = 3615;
		System.out.println("u==v? : "+(u==v)); //  true
		System.out.println("m==n? : "+(m==n)); //  false
		List<Integer> numbers = List.of(1,2,3); // 1M -> 20MB -> not cache aligned!!!, List<int> -> 4M
		for (var number : numbers) {}
		int[] array= new int[] {1,2,3};
		for (var number : array) {} // cache aligned!
		List<AA> list1; // ...|xy|xy|xy|... https://openjdk.java.net/projects/valhalla/
		// record : immutable (http://binkurt.blogspot.com/2020/04/java-14de-record-kullanm.html)
		// ...|ref|ref|ref|... Immutability
		//     \/  \/  \/
		//     xy  xy  xy
		// https://openjdk.java.net/projects/sumatra
		// https://openjdk.java.net/projects/panama
		// https://openjdk.java.net/projects/valhalla
	}

}

class AA {
	int x;
	int y;
}
