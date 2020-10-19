package ru.job4j.waitnotifynotifyall;

public class CountBarrier {
    private final Object monitor = this;

    private final int total;

    private int count = 0;

    public CountBarrier(final int total) {
        this.total = total;
    }

    public void count() {
        count++;
        if (count == total) {
            monitor.notifyAll();
        }
    }

    public void await() {
        while (!(count == total)) {
            try {
                System.out.println(Thread.currentThread().getName() + " sleep");
                monitor.wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        System.out.println("run");
    }

    public static void main(String[] args) {
        CountBarrier countBarrier = new CountBarrier(2);
        Thread first = new Thread(
                () -> {
            System.out.println(Thread.currentThread().getName() + " started");
            countBarrier.count();
            countBarrier.await();

        },
                "First"
        );
        Thread second = new Thread(
                () -> {
                    System.out.println(Thread.currentThread().getName() + " started");

                    countBarrier.count();
                }, "Second"


        );
        first.start();
        second.start();
    }

}
