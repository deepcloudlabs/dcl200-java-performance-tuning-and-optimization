package com.example;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class StudyThreadSafeCollections {
	public static void main(String[] args) {
		// CopyOnWriteArrayList
		ConcurrentHashMap<String, Integer> areaCodes = new ConcurrentHashMap<>();
		areaCodes.put("def", 222);
		areaCodes.entrySet().parallelStream().forEach(e -> {
			System.out.println(e.getKey() + ": " + e.getValue());
			areaCodes.put("abc", 111);
		});

		List<Integer> list = Collections.synchronizedList(new ArrayList<>());
		new Thread(new ProducerTask(list)).start();
		new Thread(new ConsumerTask(list)).start();
	}
}

class ProducerTask implements Runnable {
	private List<Integer> list;

	public ProducerTask(List<Integer> list) {
		this.list = list;
	}

	@Override
	public void run() {
		for (int i = 0; i < 1_000_000; ++i) {
			list.add(i);
		}
	}
}

class ConsumerTask implements Runnable {
	private List<Integer> list;

	public ConsumerTask(List<Integer> list) {
		this.list = list;
	}

	@Override
	public void run() {
		synchronized (list) {
			for (int x : list)
				System.out.println(x);
		}
	}
}