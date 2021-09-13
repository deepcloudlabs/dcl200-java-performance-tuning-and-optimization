package com.example;

public class StudyInteger {

	public static void main(String[] args) {
		Integer i = Integer.valueOf(108);
		Integer j = 108;
		Integer m = 549;
		Integer n = 549;
		System.out.println("i==j: "+(i==j));
		System.out.println("m==n: "+(m==n));
		String name1 = "Jack"; // constant pool
		String name2 = new String("Jack");
		name2 = name2.intern();  // internalize
		// G1GC, StringDeduplication
		System.out.println(name1==name2);
	}

}
