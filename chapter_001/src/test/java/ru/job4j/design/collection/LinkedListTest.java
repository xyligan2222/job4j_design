package ru.job4j.design.collection;

import org.junit.Test;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class LinkedListTest {
    @Test
    public void whenAddThenGet() {
        LinkedList<String> array = new LinkedList<>();
        array.add("first");
        String result = array.get(0);
        assertThat(result, is("first"));
    }
    @Test
    public void whenAddElements() {
        LinkedList<String> array = new LinkedList<>();
        array.add("Vasya");
        array.add("Petya");
        array.add("Typoi");
        String result = array.get(2);
        assertThat(result, is("Typoi"));
    }

    @Test
    public void whenAddThenIt() {
            LinkedList<String> array = new LinkedList<>();
            array.add("Andrew");
            Iterator<String> it = array.iterator();
            boolean rsl = it.hasNext();
            String result = it.next();
            assertThat(rsl, is(true));
            assertThat(result, is("Andrew"));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void whenGetEmpty() {
        LinkedList<String> array = new LinkedList<>();
        array.get(1);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void whenGetOutOfBounds() {
        LinkedList<String> array = new LinkedList<>();
        array.add("dddd");
        array.get(10);
    }

    @Test(expected = NoSuchElementException.class)
    public void whenEmptyIt() {
        LinkedList<String> array = new LinkedList<>();
        array.iterator().next();
    }

    @Test(expected = ConcurrentModificationException.class)
    public void whenCorruptedIt() {
        LinkedList<String> array = new LinkedList<>();
        array.add("2222");
        Iterator<String> it = array.iterator();
        array.add("323");
        it.next();
    }
}
