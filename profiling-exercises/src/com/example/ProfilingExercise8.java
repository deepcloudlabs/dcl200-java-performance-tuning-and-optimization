package com.example;

public class ProfilingExercise8 {
	private static final int SIZE = 100_000;
	private static int array[] = new int[SIZE];
	static {
		for (int i = 0; i < array.length; i++) {
			array[i] = i;
		}
	}

	public static void main(String[] args) {
		System.err.println("Array parallel sum: Arrays.stream(array).parallel().sum()");
		var start = System.currentTimeMillis();
		int sum = 0;
		for (int i = 0; i < array.length; sum += array[i], i++)
			;
		var stop = System.currentTimeMillis();
		System.err.println(sum + "@" + (stop - start));
	}
}
