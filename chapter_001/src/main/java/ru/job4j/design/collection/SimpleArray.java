package ru.job4j.design.collection;

import java.lang.reflect.Array;
import java.util.*;

public class SimpleArray<T> implements Iterable<T> {
    private  Object[] arrays;
    private int position = 0;
    private int size = 0;
    private int sizeArray = 10;
    private int modCount = 0;

    public SimpleArray() {
        this.arrays = new Object[sizeArray];
        this.size = sizeArray;
    }

    public T get(int index) {
        Objects.checkIndex(index, position);
        return (T) this.arrays[index];
    }

    public void add(T model) {
        if (this.position == this.size) {
            this.size = arrays.length + (arrays.length / 2) + 1;
            Object[] tmp = Arrays.copyOf(arrays, this.size);
            arrays = tmp;
        }
        this.arrays[this.position++] = model;
        modCount++;


    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private int count = 0;
            private int expectedModCount = modCount;

            @Override
            public boolean hasNext() {
                if (modCount != expectedModCount) {
                    throw new ConcurrentModificationException();
                }
                return count < position;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return (T) arrays[count++];
            }


        };
    }
}