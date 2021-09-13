package com.example;

import java.util.Arrays;

@SuppressWarnings("deprecation")
public class CatchMeIfYouCan {
	@Override
	protected void finalize() throws Throwable {
		super.finalize();
	}

	public static int haveFun() throws Exception {
		try (MyPreciousResource res1 = new MyPreciousResource(1);
				MyPreciousResource res2 = new MyPreciousResource(2);
				MyPreciousResource res3 = new MyPreciousResource(3);) {
			throw new Exception("Ooops!");
		}
	}

	public static void main(String[] args) throws Exception {
		try {
			System.err.println(haveFun());

		} catch (Exception e) {
			System.err.println(e.getMessage());
			Arrays.stream(e.getSuppressed()).map(Throwable::getMessage).forEach(System.err::println);
		}
	}
}

class MyPreciousResource implements AutoCloseable {
	private int id;

	public MyPreciousResource(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public void close() throws Exception {
		throw new Exception("Boom! " + id);
		// System.err.println("Closing the precious resource "+id);
	}
}