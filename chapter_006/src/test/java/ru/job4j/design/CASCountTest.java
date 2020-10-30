package ru.job4j.design;

import org.junit.Test;
import ru.job4j.nonBlocking.CASCount;


import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class CASCountTest {
    @Test
    public void increment() {

        CASCount<Integer> casCount = new CASCount<>();
        List<Integer> exp = List.of(1, 2, 3, 4, 5, 6, 7, 8);
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            casCount.increment();
            list.add(casCount.get());
        }
        assertEquals(exp, list);
    }

}