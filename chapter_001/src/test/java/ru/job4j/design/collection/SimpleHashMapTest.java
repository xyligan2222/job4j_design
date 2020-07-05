package ru.job4j.design.collection;
import org.junit.Test;

import java.util.*;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class SimpleHashMapTest {
    SimpleHashMap<Integer, String> map;



    @Test
    public void whenInsertOneThanSuccess() {
        assertThat(map.insert(1, "one"), is(true));
    }

    @Test
    public void whenInsertEqualKeysThanFalse() {
        map.insert(1, "one");
        assertThat(map.insert(1, "another one"), is(true));
    }

    @Test
    public void whenInsertEqualKeysThanHasNewValue() {
        map.insert(1, "one");
        map.insert(1, "another one");
        assertThat(map.get(1), is("another one"));
    }

    @Test
    public void whenInsertNullKey() {
        assertThat(map.insert(null, "zero"), is(true));
    }

    @Test
    public void whenInsertNullKeys() {
        map.insert(null, "one");
        assertThat(map.insert(null, "two"), is(true));
    }

    @Test
    public void whenInsertNullGetNull() {
        map.insert(null, "one");
        map.insert(null, "four");
        map.insert(null, "three");
        assertThat(map.get(null), is("three"));
    }

    @Test
    public void whenGetFromEmptyThanReturnNull() {
        assertNull(map.get(1));
    }

    @Test
    public void whenInsertOneThanGetValue() {
        map.insert(1, "one");
        assertThat(map.get(1), is("one"));
    }

    @Test
    public void whenDeleteFromEmptyStorageOrKeyNotFound() {
        assertThat(map.delete(3), is(false));
    }


    @Test
    public void whenDeleteThanSuccess() {
        map.insert(3, "three");
        assertThat(map.delete(3), is(true));
    }

    @Test
    public void whenDeleteThanHasNoSuchKey() {
        map.insert(3, "three");
        map.delete(3);
        assertNull(map.get(3));
    }


    @Test
    public void whenMultiInsertAndMultiDelete() {
        assertTrue(map.insert(1, "one"));
        assertTrue(map.insert(2, "two"));
        assertTrue(map.insert(3, "three"));
        assertTrue(map.insert(4, "four"));
        assertTrue(map.insert(5, "five"));
        assertTrue(map.delete(1));
        assertTrue(map.delete(2));
        assertTrue(map.delete(3));
        assertTrue(map.delete(4));
        assertTrue(map.delete(5));
        assertNull(map.get(1));
        assertNull(map.get(2));
        assertNull(map.get(3));
        assertNull(map.get(4));
        assertNull(map.get(5));
    }


    @Test(expected = NoSuchElementException.class)
    public void whenIteratorInEmpty() {
        Iterator<SimpleHashMap.Node<Integer, String>> it = map.iterator();
        it.next();
    }


    @Test
    public void whenInsertOneThanIteratorNext() {
        map.insert(1, "one");
        Iterator<SimpleHashMap.Node<Integer, String>> it = map.iterator();
        assertThat(it.next().getValue(), is("one"));
    }


    @Test(expected = ConcurrentModificationException.class)
    public void whenInsertDuringIteration() {
        map.insert(1, "one");
        Iterator<SimpleHashMap.Node<Integer, String>> it = map.iterator();
        it.next();
        map.insert(2, "two");
        it.next();
    }


    @Test
    public void whenHasNextAfterOne() {
        map.insert(1, "one");
        Iterator<SimpleHashMap.Node<Integer, String>> it = map.iterator();
        it.next();
        assertFalse(it.hasNext());
    }


    @Test
    public void testResize() {
        for (int i = 1; i < 20; i++) {
            assertTrue(map.insert(i, "" + i));
        }
    }

    @Test
    public void whenInsertReturnFalse() {
        class User {
            int id;
            String name;
            GregorianCalendar birthDate;

            User(int id, String name, GregorianCalendar birthDate) {
                this.id = id;
                this.name = name;
                this.birthDate = birthDate;
            }

            @Override
            public boolean equals(Object o) {
                if (this == o) {
                    return true;
                }
                if (o == null || getClass() != o.getClass()) {
                    return false;
                }
                User user = (User) o;
                return id == user.id
                        && Objects.equals(name, user.name)
                        && Objects.equals(birthDate, user.birthDate);
            }

            @Override
            public int hashCode() {
                return 31;
            }
        }
        SimpleHashMap<User, String> map = new SimpleHashMap<>();
        User user1 = new User(123456789, "user1", new GregorianCalendar(1990, 12, 12));
        User user2 = new User(1, "user2", new GregorianCalendar(1990, 12, 12));
        map.insert(user1, "user1");
        assertThat(map.insert(user2, "user1"), is(false));
    }
}