package ru.job4j.design.collection;

import java.util.NoSuchElementException;

public class SimpleQueue<T> {
    private final SimpleStack<T> in = new SimpleStack<>();
    private final SimpleStack<T> out = new SimpleStack<>();
    private int count = 0;

    public T poll() {
        if (in == null) {
            throw new NoSuchElementException();
        }
        for (int i = 0; i < count; i++) {
            out.push(in.pop());
        }
        count = 0;
        return out.pop();
    }

    public void push(T value) {
        in.push(value);
        count++;
    }
}
