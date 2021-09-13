package com.example;
import static java.util.stream.Collectors.toList;

import java.util.List;
import java.util.Random;

public class StudyRunnableThread {
	public static void main(String[] args) {
		LotteryTask task = new LotteryTask();
		Thread t = new Thread(task);
		t.start();
		while (true) {
			try {
				t.join(10);
				if (t.isAlive()) {
					System.out.println("Working hard!");
				} else {
					System.out.println(task.getNumbers());
					break;
				}
			} catch (InterruptedException e) {
			}
		}
	}
}

class LotteryTask implements Runnable {

	private List<Integer> numbers;

	@Override
	public void run() {
		numbers = new Random().ints(1, 50).distinct().limit(6).sorted().boxed().collect(toList());
	}

	public List<Integer> getNumbers() {
		return numbers;
	}
}
