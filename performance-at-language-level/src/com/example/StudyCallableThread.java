package com.example;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;

import static java.util.stream.Collectors.toList;

public class StudyCallableThread {
    public static void main(String[] args)  {
        LotteryFutureTask task= new LotteryFutureTask();
        FutureTask<List<Integer>> future = new FutureTask<>(task);
        Thread t = new Thread(future);
        t.start();
        while(true){
            try {
                List<Integer> numbers = future.get(10, TimeUnit.MILLISECONDS);
                System.out.println(numbers);
                break;
            } catch (InterruptedException | ExecutionException | TimeoutException e) {
                System.out.println("Working hard!");
            }
        }
    }
}

class LotteryFutureTask implements Callable<List<Integer>> {

    @Override
    public List<Integer> call() {
        return new Random().ints(1, 50)
                .distinct()
                .limit(6)
                .sorted()
                .boxed()
                .collect(toList());
    }

}
