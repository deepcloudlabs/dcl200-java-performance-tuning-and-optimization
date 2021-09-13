package com.example;

import java.util.Arrays;

public class ProfilingExercise7 {
	private static final int SIZE = 100_000;
	private static int array[] = new int[SIZE];
	static {
		for (int i = 0; i < array.length; i++) {
			array[i] = i;
		}
	}

	public static void main(String[] args) {
		System.err.println("Array parallel sum: Arrays.stream(array).parallel().sum()");
		int sum = Arrays.stream(array).parallel().sum();
		System.err.println(sum);
	}
}
