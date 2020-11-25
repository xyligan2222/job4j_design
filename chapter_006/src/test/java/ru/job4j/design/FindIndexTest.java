package ru.job4j.design;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import ru.job4j.pool.FindIndex;

public class FindIndexTest {

    @Test
    public void whenIndexIs2() {
        FindIndex<Integer> findIndex = new FindIndex<>();
        Integer[] users = new Integer[]{1, 2, 3, 6, 5, 8, 9, 0};
        int result = findIndex.parallelFind(users, 3);
        assertThat(result, is(2));
    }

    @Test
    public void whenIndexIs14() {
        FindIndex<Integer> findIndex = new FindIndex<>();
        Integer[] users = new Integer[]{1, 2, 3, 6, 5, 8, 9, 0, 12, 456, 234, 567, 4534, 324, 657, 435, 2, 12, 435, 23, 123, 7};
        int result = findIndex.parallelFind(users, 657);
        assertThat(result, is(14));
    }
}
