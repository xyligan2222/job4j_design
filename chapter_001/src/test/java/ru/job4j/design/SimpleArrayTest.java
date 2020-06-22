package ru.job4j.design;
import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;

import org.junit.Test;
import ru.job4j.design.generic.SimpleArray;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
public class SimpleArrayTest {
    private Iterator<?> simplyArrayIt;

    @Test(expected = NoSuchElementException.class)
    public void whenSevenElementAdd() {
        SimpleArray<Integer> array = new SimpleArray<>();
        array.add(1);
        array.add(2);
        array.add(3);
        array.add(4);
        array.add(5);
        array.add(6);
        array.add(7);
        simplyArrayIt = array.iterator();
        assertThat(simplyArrayIt.hasNext(), is(true));
        assertThat(simplyArrayIt.next(), is(1));
        assertThat(simplyArrayIt.hasNext(), is(true));
        assertThat(simplyArrayIt.next(), is(2));
        assertThat(simplyArrayIt.hasNext(), is(true));
        assertThat(simplyArrayIt.next(), is(3));
        assertThat(simplyArrayIt.hasNext(), is(true));
        assertThat(simplyArrayIt.next(), is(4));
        assertThat(simplyArrayIt.hasNext(), is(true));
        assertThat(simplyArrayIt.next(), is(5));
        assertThat(simplyArrayIt.hasNext(), is(true));
        assertThat(simplyArrayIt.next(), is(6));
        assertThat(simplyArrayIt.hasNext(), is(true));
        assertThat(simplyArrayIt.next(), is(7));
        assertThat(simplyArrayIt.hasNext(), is(false));
        simplyArrayIt.next();
    }

    @Test(expected = NoSuchElementException.class)
    public void whenEmptyArray() {
        SimpleArray<Integer> array = new SimpleArray<>();
        simplyArrayIt = array.iterator();
        assertThat(simplyArrayIt.hasNext(), is(false));
        simplyArrayIt.next();
    }
    @Test
    public void whenSetElement() {
        SimpleArray<Integer> array = new SimpleArray<>();
        array.add(0);
        array.add(1);
        array.add(2);
        assertThat(array.set(0, 5), is(5));
    }
    @Test
    public void whenRemoveElement() {
        SimpleArray<Integer> array = new SimpleArray<>();
        array.add(0);
        array.add(1);
        array.add(2);
        array.remove(0);
        assertThat(array.set(0, 1), is(1));
    }
    @Test(expected = ConcurrentModificationException.class)
    public void whenConcurrentModificationException() {
        SimpleArray<Integer> array = new SimpleArray<>();
        Iterator<Integer> simplyArrayIt = array.iterator();
        array.add(0);
        array.add(1);
        array.add(2);
        array.set(2, 3);
        array.remove(0);
        simplyArrayIt.hasNext();

    }

}
