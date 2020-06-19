package ru.job4j.design.it;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class EvenNumbersIterator implements Iterator<Integer> {
    private final int[] data;
    private int point = 0;

    public EvenNumbersIterator(int[] data) {
        this.data = data;
    }

    @Override
    public boolean hasNext() {
        int even = 0;
        if (point < data.length) {
            for (int i = point; i < data.length; i++) {
                if (data[i] % 2 == 0 || data[i] == 2) {
                    even++;
                    point = i;
                    break;
                }
            }
        }
        return even > 0;
    }

    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return data[point++];
    }
}
