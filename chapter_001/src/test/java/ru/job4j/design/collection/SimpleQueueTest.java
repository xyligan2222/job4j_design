package ru.job4j.design.collection;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;

import org.junit.Ignore;
import org.junit.Test;

import java.util.NoSuchElementException;

public class SimpleQueueTest {

    @Test
    @Ignore
    public void whenPushPoll() {
        SimpleQueue<Integer> queue = new SimpleQueue<>();
        queue.push(1);
        int rsl = queue.poll();
        assertThat(rsl, is(1));
    }

    @Test
    @Ignore
    public void when2PushPoll() {
        SimpleQueue<Integer> queue = new SimpleQueue<>();
        queue.push(1);
        queue.push(2);
        int rsl = queue.poll();
        assertThat(rsl, is(1));
    }

    @Test
    @Ignore
    public void when2PushPollPushPoll() {
        SimpleQueue<Integer> queue = new SimpleQueue<>();
        queue.push(1);
        queue.poll();
        queue.push(2);
        int rsl = queue.poll();
        assertThat(rsl, is(2));
    }

    @Test(expected = NoSuchElementException.class)
    @Ignore
    public void whenEmptyPoll() {
        SimpleQueue<Integer> queue = new SimpleQueue<>();
        queue.poll();
    }

    @Test
    @Ignore
    public void when3PushPollPushPoll() {
        SimpleQueue<Integer> queue = new SimpleQueue<>();
        queue.push(1);
        queue.push(2);
        queue.push(3);
        int rsl = queue.poll();
        assertThat(rsl, is(1));
        queue.push(4);
        int rsl2 = queue.poll();
        assertThat(rsl2, is(2));

    }
}