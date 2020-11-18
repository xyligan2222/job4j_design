package ru.job4j.pool;

import ru.job4j.waitnotifynotifyall.SimpleBlockingQueue;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

public class ThreadPool {
    private final int size = Runtime.getRuntime().availableProcessors();
    private final List<Thread> threads = new LinkedList<>();
    private final SimpleBlockingQueue<Runnable> tasks = new SimpleBlockingQueue<>(size);

    public void work(Runnable job) {
        tasks.offer(job);
    }

    public void shutdown() {
        for (Thread thread : threads) {
            thread.interrupt();
        }
    }

    public ThreadPool() {
        for (int i = 0; i < size; i++) {
            Thread thread = new Thread(
                    () -> {
                        while (!Thread.currentThread().isInterrupted()) {
                            tasks.poll().run();
                        }
                    });
            threads.add(thread);
            thread.start();
        }
    }

    public static void main(String[] args) {
        ThreadPool threadPool = new ThreadPool();
        for (int i = 0; i < 100000; i++) {
            threadPool.work(() -> System.out.println(Thread.currentThread().getName() + " Worked"));
        }
        threadPool.shutdown();
    }
}