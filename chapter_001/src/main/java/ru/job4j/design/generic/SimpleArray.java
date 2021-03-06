package ru.job4j.design.generic;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

public class SimpleArray<T> implements Iterable {
    private final Object[] arrays;
    private int position = 0;
    private final int size;
    private int sizeArray = 10;
    private int modCount = 0;


    public SimpleArray() {
        this.arrays = new Object[sizeArray];
        this.size = sizeArray;
    }

    public SimpleArray(int size) {
        this.arrays = new Object[size];
        this.size = size;
    }

    public boolean add(T model) {
        Objects.checkIndex(this.position, this.size);
        this.arrays[this.position++] = model;
        modCount++;
        return true;
    }

    public T set(int index, T model) {
        Objects.checkIndex(index, this.position);
        this.arrays[index] = model;
        modCount++;
        return (T) this.arrays[index];
    }

    public T remove(int index) {
        T result = (T) this.arrays;
        Objects.checkIndex(index, size);
        this.arrays[index] = null;
        System.arraycopy(arrays, index + 1, arrays, index, size - index - 1);
        this.position--;
        modCount++;
        return result;
    }

    @Override
    public Iterator iterator() {
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
