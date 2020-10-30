package ru.job4j.nonBlocking;

import net.jcip.annotations.ThreadSafe;

import java.util.concurrent.atomic.AtomicReference;

@ThreadSafe
public class CASCount<T> {
    private final AtomicReference<Integer> count = new AtomicReference<>(0);

    public void increment() {
        int value;
        do {
            value = get();
        } while (!count.compareAndSet(value, value + 1));
    }

    public int get() {
        return count.get();
    }
}
