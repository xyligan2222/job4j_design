package ru.job4j.pool;

import java.util.Arrays;
import java.util.Objects;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;
import java.util.stream.IntStream;

public class FindIndex<T>  {

    public int linearFind(T[] array, T value) {
        return IntStream.range(0, array.length)
                .filter(i -> array[i].equals(value))
                .findFirst()
                .orElse(-1);
    }

    public int parallelFind(T[] array, T value) {
        if (array.length < 10) {
            return linearFind(array, value);
        }
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        return forkJoinPool.invoke(new ParallelTask<>(array, (Integer) value));
    }
}
