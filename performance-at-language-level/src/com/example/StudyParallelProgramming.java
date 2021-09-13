package com.example;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;
import java.util.stream.IntStream;

public class StudyParallelProgramming {
    private static final int ARRAY_SIZE = 20_000_000;
    private static final int LOOP = 5;
    private static double[] numbers= new double[ARRAY_SIZE];

    private static final int NUM_OF_CPUS;

    static {
        System.err.println("Initializing array...");
        IntStream.range(0,ARRAY_SIZE)
                .forEach( i -> numbers[i]= i);
        System.err.println("Initializing array...done.");
        NUM_OF_CPUS= Runtime.getRuntime().availableProcessors();
    }
    public static void main(String[] args)  {
        System.err.println("Serial Solver is running...");
        IntStream.range(0,LOOP).forEach(i -> serialSolver());
        System.err.println("Serial Solver is running...done.");
        System.err.println("Parallel Solver is running...");
        IntStream.range(0,LOOP).forEach(i -> parallelSolver());
        System.err.println("Parallel Solver is running...done.");
        System.err.println("Parallel Stream Solver is running...");
        IntStream.range(0,LOOP).forEach(i -> parallelStreamSolver());
        System.err.println("Parallel Stream Solver is running...done.");
    }

    private static void parallelStreamSolver() {
        System.gc();
        long start= System.currentTimeMillis();
        double sum= Arrays.stream(numbers)
                .parallel()
                .sum();
        long stop= System.currentTimeMillis();
        System.err.println(String.format("%10s : %12f, %8d ms",
                "PARALLEL8", sum, (stop-start)));
        System.gc();
    }

    private static void parallelSolver() {
        System.gc();
        List<Future<Long>> partialSums= new ArrayList<>();
        ExecutorService executor= Executors.newFixedThreadPool(NUM_OF_CPUS);

        int partialSize= ARRAY_SIZE / NUM_OF_CPUS;
        long start= System.currentTimeMillis();
        for (int i = 0, j = 0; i<NUM_OF_CPUS; i++,j+=partialSize){
            Future<Long> ft=executor.submit(new ParallelSumTask(numbers,j,partialSize));
            partialSums.add(ft);
        }
        long sum= 0;
        for (Future<Long> partialSum : partialSums){
            try {
                sum += partialSum.get();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        long stop= System.currentTimeMillis();
        System.err.println(String.format("%10s : %12d, %8d ms",
                "PARALLEL", sum, (stop-start)));
        executor.shutdown();
        System.gc();
    }

    private static void serialSolver() {
        System.gc();
        long sum= 0;
        long start= System.currentTimeMillis();
        for (double v: numbers) sum += v;
        long stop= System.currentTimeMillis();
        System.err.println(String.format("%10s : %12d, %8d ms",
                "SERIAL", sum, (stop-start)));
        System.gc();
    }
}

class ParallelSumTask implements Callable<Long> {
    private double[] array;
    private int start;
    private int size;

    public ParallelSumTask(double[] array, int start, int size) {
        this.array = array;
        this.start = start;
        this.size = size;
    }

    @Override
    public Long call() throws Exception {
        long sum= 0;
        for (int i=start,j=0;j<size;++i,++j){
            sum += array[i];
        }
        return sum;
    }
}