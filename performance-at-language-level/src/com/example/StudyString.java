package com.example;

public class StudyString {

	public static void main(String[] args) {
		String name1 = "jack"; // static string -> object pooling -> immutable
		String name2 = new String("jack"); // dynamic string -> Heap
		String name3 = "jack"; // static string -> object pooling
		name2 = name2.intern(); // Heap ("jack") -> Garbage Collection
		System.err.println("name1 == name2 : "+(name1==name2));
		System.err.println("name1 == name3 : "+(name1==name3));
		// GC -> G1GC -> String Deduplication	
		// Java SE 8 String Deduplication
		// -XX:+UseStringDeduplication
		// -XX:+PrintStringDeduplicationStatistics
		// Since Java 9: -Xlog:stringdeduplication=debug
	}

}
