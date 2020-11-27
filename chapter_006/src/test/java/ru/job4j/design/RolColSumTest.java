package ru.job4j.design;

import org.junit.Test;
import ru.job4j.pool.RolColSum;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.concurrent.ExecutionException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class RolColSumTest {
    @Test
    public void whenSum() {
        long start = System.currentTimeMillis();
        int[][] array = {{1, 2, 3}, {1, 2, 2}};
        RolColSum.Sums[] rsl = RolColSum.sum(array);
        assertThat(rsl[0].getColSum(), is(2));
        assertThat(rsl[0].getRowSum(), is(6));
        assertThat(rsl[1].getColSum(), is(4));
        assertThat(rsl[1].getRowSum(), is(5));
       // System.out.println(System.currentTimeMillis() - start);
    }

    @Test
    public void whenAsyncSum() throws ExecutionException, InterruptedException {
        long start = System.currentTimeMillis();
        int[][] array = {{1, 2, 3, 4, 5}, {1, 2, 2, 4, 3}, {6, 6, 6, 3, 5}};
        RolColSum.Sums[] rsl = RolColSum.asyncSum(array);
        assertThat(rsl[0].getColSum(), is(8));
        assertThat(rsl[0].getRowSum(), is(15));
        assertThat(rsl[1].getColSum(), is(10));
        assertThat(rsl[1].getRowSum(), is(12));
        assertThat(rsl[2].getColSum(), is(11));
        assertThat(rsl[2].getRowSum(), is(26));
       // System.out.println(System.currentTimeMillis() - start);
    }

    @Test
    public void whenSum2() throws ExecutionException, InterruptedException {
        long start = System.currentTimeMillis();
        int[][] array = {{1, 2, 3, 4, 5}, {1, 2, 2, 4, 3}, {6, 6, 6, 3, 5}};
        RolColSum.Sums[] rsl = RolColSum.sum(array);
        assertThat(rsl[0].getColSum(), is(8));
        assertThat(rsl[0].getRowSum(), is(15));
        assertThat(rsl[1].getColSum(), is(10));
        assertThat(rsl[1].getRowSum(), is(12));
        assertThat(rsl[2].getColSum(), is(11));
        assertThat(rsl[2].getRowSum(), is(26));
        //System.out.println(System.currentTimeMillis() - start);
    }
}