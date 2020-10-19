package ru.job4j.design;

import java.util.stream.IntStream;

import org.junit.Test;
import ru.job4j.waitnotifynotifyall.SimpleBlockingQueue;

import java.util.Arrays;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.IntStream;

import static org.junit.Assert.assertEquals;

public class SimpleBlockingQueueTest {
    @Test
    public void blockingQueue() throws InterruptedException {
        SimpleBlockingQueue<Integer> simpleBlockingQueue = new SimpleBlockingQueue<>(5);
        Thread producer = new Thread(
                () -> {
                    int i = 0;
                    while (i <= 10 && !Thread.currentThread().isInterrupted()) {
                        simpleBlockingQueue.offer(i);
                        i++;
                    }
                    System.out.println("Producer is dead");
                }, "offer"
        );
        Thread consumer = new Thread(
                () -> {
                    int i = 0;
                    while (i <= 10) {
                        simpleBlockingQueue.poll();
                        i++;
                    }
                    System.out.println("Consumer is dead");
                }, "poll"
        );
        producer.start();
        consumer.start();
        producer.join();
        consumer.interrupt();
    }

}
