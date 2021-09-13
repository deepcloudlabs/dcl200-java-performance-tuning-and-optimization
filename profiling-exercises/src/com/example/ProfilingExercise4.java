package com.example;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.IntStream;

public class ProfilingExercise4 {

	public static void main(String[] args) {
		List<Thread> threads = new ArrayList<>();
		Task task = new Task();
		IntStream.rangeClosed(1, 10).forEach(i -> threads.add(new Thread(task)));
		threads.forEach(Thread::start);
		threads.forEach(t -> {
			try {
				t.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		});
		System.out.println(task.getCounter());
	}

}

class Task implements Runnable {
	private volatile int counter = 0;
	private Lock lock = new ReentrantLock();

	public long getCounter() {
		return counter;
	}

	@Override
	public void run() {
		for (int j = 0; j < 2_000_000; ++j) {
			for (int i = 0; i < 20_000; ++i) {
				lock.lock();
				try {
					lock.lock();
					counter++;
				} finally {
					lock.unlock();
				}
			}
		}
	}

}