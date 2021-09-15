package com.example;

public class Exercise3 {

	public static void main(String[] args) throws InterruptedException {
		StringBuffer s = new StringBuffer(20_000_000); // Immutable
		long start = System.currentTimeMillis();
		for(var i=0;i<20_000_000;++i) {
			s.append(i); 
//			if (i%10_000 == 0)
//				TimeUnit.MILLISECONDS.sleep(10);
		}
		long stop = System.currentTimeMillis();
		System.out.println(String.format("String length: %d @ %d ms.", s.length(),stop-start));
	}

}
