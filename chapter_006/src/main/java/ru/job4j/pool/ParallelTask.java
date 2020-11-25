package ru.job4j.pool;

import java.util.Arrays;
import java.util.Objects;
import java.util.concurrent.RecursiveTask;

public class ParallelTask<T> extends RecursiveTask<Integer> {
    private final T[] array;
    private final int from;
    private final int to;
    private final int valueFind;

    public ParallelTask(T[] array, int valueFind) {
        this.array = array;
        this.from = 0;
        this.to = array.length - 1;
        this.valueFind = valueFind;
    }

    public ParallelTask(T[] array, int from, int to, int valueFind) {
        this.array = array;
        this.from = from;
        this.to = to;
        this.valueFind = valueFind;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ParallelTask)) return false;
        ParallelTask<?> that = (ParallelTask<?>) o;
        return from == that.from &&
                to == that.to &&
                valueFind == that.valueFind &&
                Arrays.equals(array, that.array);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(from, to, valueFind);
        result = 31 * result + Arrays.hashCode(array);
        return result;
    }

    /**
     * The main computation performed by this task.
     *
     * @return the result of the computation
     */
    @Override
    protected Integer compute() {
        if (from == to) {
            if (array[from].equals(valueFind)) {
                return from;
            }
            return -1;
        }
        int mid = (from + to) / 2;
        ParallelTask<T> leftFind = new ParallelTask<>(array, from, mid, valueFind);
        ParallelTask<T> rightFind= new ParallelTask(array, mid + 1, to, valueFind);
        leftFind.fork();
        rightFind.fork();
        return Math.max(leftFind.join(), rightFind.join());
    }
}
