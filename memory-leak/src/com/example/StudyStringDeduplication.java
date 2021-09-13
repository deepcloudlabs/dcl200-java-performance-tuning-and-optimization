package com.example;

public class StudyStringDeduplication {
	public static void main(String[] args) throws InterruptedException {
		String s[] = new String[100_000];
		for (int i = 0; i < 1_000; ++i) {
			for (int j = 0; j < 100_000; ++j) {
				s[i] = new String("String");
			}
			Thread.sleep(10);
		}
	}
}
