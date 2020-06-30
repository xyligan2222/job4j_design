package ru.job4j.design.collection;

import java.util.Iterator;
import java.util.Objects;

public class SimpleSet<T> implements Iterable<T> {
    private SimpleArray<T> simpleArray = new SimpleArray<T>();

    public boolean checkDupli(T model) {
        boolean rsl = false;
        Iterator<T> it = simpleArray.iterator();
        while (it.hasNext()) {
            if (it.next().equals(model)) {
                rsl = true;
                break;
            }
        }
        return rsl;
    }

    public boolean add(T model) {
        boolean rsl = false;
            if (!checkDupli(model)) {
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
