package com.example;

import java.util.ArrayList;

public class Exercise6 {

	public static void main(String[] args) {
		/*
		var toLowerCase = String.class.getMethod("toLowerCase");
		var name = "Jack";
		toLowerCase.invoke(name);
		*/
		var numbers = new ArrayList<>();
		var start = System.nanoTime();
		for (var i=0;i<1_000_000;++i) {
			numbers.add(i);
		}
		var stop = System.nanoTime();
		System.err.println("Duration: "+(stop-start));
		// Load Factor=0.5 -> %50, Capacity: 10000, o.hashCode() -> f() -> index -> ArrayList[index]
		// hashCode: attributes -> integer, o1 -> index <- o2: collusion
		// data size: 30000 / 0.75 -> 
		//HashSet<Integer> numbers = new HashSet<>(40_000);
		
		
		

	}

}
