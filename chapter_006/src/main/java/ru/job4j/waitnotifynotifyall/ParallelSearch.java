package ru.job4j.waitnotifynotifyall;



public class ParallelSearch {

    public static void main(String[] args) throws InterruptedException {
        SimpleBlockingQueue<Integer> queue = new SimpleBlockingQueue<Integer>(4);
        final Thread producer = new Thread(
                () -> {
                    for (int index = 0; index != 6; index++) {
                        queue.offer(index);
                    }
                }, "Producer"
        );

        final Thread consumer = new Thread(
                () -> {
                    while (!queue.isEmpty() || !Thread.currentThread().isInterrupted()) {
                        System.out.println(queue.poll());
                    }
                }, "Consumer"
        );
        producer.start();
        consumer.start();
        producer.join();
        consumer.interrupt();
        consumer.join();
    }
}