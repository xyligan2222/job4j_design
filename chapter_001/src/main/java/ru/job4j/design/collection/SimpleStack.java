package ru.job4j.design.collection;



import java.util.Iterator;
import java.util.NoSuchElementException;

public class SimpleStack<T> {
    private ForwardLinked<T> linked = new ForwardLinked<T>();

    public T pop() {
        return linked.deleteLast();
    }

    public void push(T value) {
        linked.add(value);
    }
}