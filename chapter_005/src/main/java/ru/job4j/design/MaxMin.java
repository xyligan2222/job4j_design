package ru.job4j.design;

import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class MaxMin {
    public <T> T max(List<T> value, Comparator<T> comparator) {
        T rsl =  value.isEmpty() ? null : searchMaxMin(value, comparator.reversed());
        System.out.println(rsl);
        return rsl;
    }

    public <T> T min(List<T> value, Comparator<T> comparator) {
        T rsl =  value.isEmpty() ? null : searchMaxMin(value, comparator);
        System.out.println(rsl);
        return rsl;
    }

    public static <T> T searchMaxMin(List<T> list, Comparator<T> comparator) {
        Iterator<T> iterator = list.iterator();
        T value = iterator.next();
        while (iterator.hasNext()) {
            T current = iterator.next();
            if (comparator.compare(value, current) > 0) {
                value = current;
            }
        }
        return value;
    }

    public static void main(String[] args) {
        List<Integer> list = List.of(1, 4, 8, -1, 4, 3, 9, -23, -10);
        MaxMin maxMin = new MaxMin();
        maxMin.min(list, Comparator.naturalOrder());
        maxMin.max(list, Comparator.naturalOrder());
    }
}