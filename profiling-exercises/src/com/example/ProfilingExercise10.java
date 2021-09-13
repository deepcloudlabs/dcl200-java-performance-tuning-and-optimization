package com.example;

import java.util.concurrent.CompletableFuture;

public class ProfilingExercise10 {

	public static void main(String[] args) {
		CompletableFuture.supplyAsync(() -> 5).thenApply(i -> i * 3).thenRun(() -> System.out.println("Finished 1 ."))
				.thenRunAsync(() -> {
					try {
						Thread.sleep(1000);
						System.out.println("Finished 2.");
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}).thenRunAsync(() -> System.out.println("Finished 3."));

	}

}
