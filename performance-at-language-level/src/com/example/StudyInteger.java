package com.example;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StudyInteger {

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		int x=3, y= 5;
		var z = x + y;
		Integer u= 3, v = 5;
		Integer w = Integer.valueOf(u.intValue() + v.intValue());
		System.err.println("z="+z);
		System.err.println("w="+w.toString());
		List<Integer> list= new ArrayList<>();
		list.add(Integer.valueOf(42));
		Object o = Integer.valueOf(42);
		int[] numbers = new int[5] ;
		
		var sum = IntStream.rangeClosed(1, 100).sum();
		var lotteryNumbers = ThreadLocalRandom.current().ints(1,60)
		                           .distinct() // int
		                           .limit(6) // int
		                           .sorted() // int
		                           .boxed() // int (4B) -> Integer (20B)
		                           .collect(Collectors.toList());
		     
	}

}
