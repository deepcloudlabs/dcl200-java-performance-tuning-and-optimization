package com.example;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.function.IntConsumer;
import java.util.stream.IntStream;

public class StudyThreadPools {
    public static void main(String[] args) {
        int numberOfLogicalProcessors =
                Runtime.getRuntime().availableProcessors();
        ExecutorService service = Executors.newFixedThreadPool(numberOfLogicalProcessors);
        LotteryFutureTask task = new LotteryFutureTask();
        IntConsumer submitAndConsume = i -> {
            Future<List<Integer>> numbers = service.submit(task);
            try {
                System.out.println(numbers.get().size());
            } catch (Exception e) {
                e.printStackTrace();
            }
        };
        IntStream.range(0, 1_000_000)
                // .parallel()
                .forEach(submitAndConsume);
        service.shutdown();
    }
}

