package com.example;
import java.util.concurrent.atomic.AtomicInteger;

public class ProcessMemoryModel {
    public static void main(String[] args) throws InterruptedException {
        MyTask task= new MyTask();
        Thread t1= new Thread(task);
        Thread t2= new Thread(task);
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(task.getData());
    }
}

class MyTask implements  Runnable {
    private AtomicInteger data= new AtomicInteger(0);

    @Override
    public void run() {
        for (int i=0;i<1_000_000;++i){
            this.data.incrementAndGet(); // critical section
        }

    }

    public int getData() {
        return data.get();
    }
}
