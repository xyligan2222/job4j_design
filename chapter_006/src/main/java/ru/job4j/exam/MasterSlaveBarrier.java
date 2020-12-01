package ru.job4j.exam;

import java.util.concurrent.atomic.AtomicInteger;

public class MasterSlaveBarrier {
    private final AtomicInteger count = new AtomicInteger(0);

    public synchronized void tryMaster()  {
        while (count.get() % 2 == 1) {
            try {
                wait();
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }

    public synchronized void trySlave() {
        while (count.get() % 2 == 0) {
            try {
                wait();
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

    }

    public synchronized void doneMaster() {
        System.out.println(Thread.currentThread().getName());
        count.getAndIncrement();
        System.out.println(count.get());
        notify();

    }

    public synchronized void doneSlave() {
        System.out.println(Thread.currentThread().getName());
        count.getAndIncrement();
        System.out.println(count.get());
        notify();
    }
}