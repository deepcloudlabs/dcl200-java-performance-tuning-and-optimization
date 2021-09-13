package com.example;

import static java.util.concurrent.CompletableFuture.runAsync;
import static java.util.stream.Collectors.toList;

import java.util.List;
import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

public class StudyCompletableFuture {

	public static void main(String[] args) throws InterruptedException {
		CompletableFuture.supplyAsync(StudyCompletableFuture::sun).thenAcceptAsync(StudyCompletableFuture::run);
		runAsync(StudyCompletableFuture::fun).thenRun(() -> System.err.println("Done."));
		runAsync(StudyCompletableFuture::gun).thenRun(() -> System.err.println("Done."));
		Thread.sleep(10_000);
	}

	public static List<Integer> sun() {
		return new Random().ints(1, 50).distinct().limit(6).sorted().boxed().collect(toList());
	}

	public static List<Integer> run(List<Integer> numbers) {
		System.err.println(numbers);
		return numbers;
	}

	public static void fun() {
		try {
			TimeUnit.SECONDS.sleep(3);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.err.println("Have fun!");
	}

	public static void gun() {
		System.err.println("Have gun!");
	}
}
