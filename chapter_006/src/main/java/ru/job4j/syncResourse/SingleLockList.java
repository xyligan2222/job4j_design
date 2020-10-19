package ru.job4j.syncResourse;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;
import ru.job4j.design.collection.LinkedList;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@ThreadSafe
public class SingleLockList<T> implements Iterable<T> {

    @GuardedBy("this")
    private final LinkedList<T> store = new LinkedList<T>();

    public synchronized void add(T value) {
        store.add(value);
    }

    public synchronized T get(int index) {
        return store.get(index);
    }

    @Override
    public synchronized Iterator<T> iterator() {
        return copy().iterator();
    }

    private synchronized LinkedList<T> copy() {
        LinkedList<T> copy = this.store;
        return copy;
    }
}