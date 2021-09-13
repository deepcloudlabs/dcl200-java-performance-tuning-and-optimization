package com.example;

public class MeasureSchedulerOverhead {
    public static void main(String[] args) throws InterruptedException {
        long start = System.currentTimeMillis();
        for (int i = 0; i < 2_000; i++) {
            Thread.sleep(2);
        }
        long end = System.currentTimeMillis();
        System.out.println("Millis elapsed: " + (end - start) / 4000.0);
    }

}
