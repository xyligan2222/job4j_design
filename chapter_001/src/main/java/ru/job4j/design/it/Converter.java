package ru.job4j.design.it;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;


public class Converter {

    public Iterator<Integer> convert(Iterator<Iterator<Integer>> iter) {
        return new Iterator<Integer>() {
            private Iterator<Integer> iterator = (new ArrayList<Integer>()).iterator();
            @Override
            public boolean hasNext() {

                while (iter.hasNext() && !iterator.hasNext()) {
                    iterator = iter.next();
                }
                return iterator.hasNext();
            }

            @Override
            public Integer next() {
                if (!this.hasNext()) {
                    throw new NoSuchElementException();
                }
                return iterator.next();
            }
        };
    }
}
