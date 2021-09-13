package com.example;
public class StudyWrapperArithmetic {
	public static void main(String[] args) {
		Integer[] numbers = { 4, 8, 15, 16, 23, 42 };
		Integer sum = 0;
		for (Integer x : numbers) {
			sum += x;
			sum = Integer.valueOf(sum.intValue() + x.intValue());

		}
		System.out.println(sum);
	}
}