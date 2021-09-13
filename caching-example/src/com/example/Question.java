package com.example;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Question {
	public static void main(String[] args) {
		A a = new A();
		IntStream.range(0, 1_000).forEach(i -> {
			a.fun();
		});
	}
}

class A {
	public int fun() { // Escape Analysis
		int[] array = new int[1_000_000]; // Humongous Object ==> Tenure
		return Arrays.stream(array).sum();
	}
}
