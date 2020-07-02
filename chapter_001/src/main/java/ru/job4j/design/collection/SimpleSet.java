package ru.job4j.design.collection;

import java.util.Iterator;
import java.util.Objects;

public class SimpleSet<T> implements Iterable<T> {
    private SimpleArray<T> simpleArray = new SimpleArray<T>();

    public boolean contains(T model) {
        boolean rsl = false;
        Iterator<T> it = simpleArray.iterator();
        while (it.hasNext()) {
            if (Objects.equals(it.hasNext(), model)) {
                rsl = true;
                break;
            }
        }
        return rsl;

    }

    public boolean add(T model) {
        boolean rsl = false;
            if (!contains(model)) {
                this.simpleArray.add(model);
                rsl = true;
            }
            return rsl;
    }

    @Override
    public Iterator<T> iterator() {
        return simpleArray.iterator();
    }
}
