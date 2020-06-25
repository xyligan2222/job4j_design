package ru.job4j.design.collection;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

public class LinkedList<T> implements Iterable<T> {
    private int size = 0;
    private int modCount = 0;
    private Node<T> first;
    private Node<T> last;

    public LinkedList() {
    }


    private static class Node<T> {
        T item;
        Node<T> next;
        Node<T> prev;

        Node(Node<T> next, T element, Node<T> prev) {
            this.next = next;
            this.item = element;
            this.prev = prev;
        }
    }

    public void add(T value) {
        final Node<T> l = last;
        final Node<T> newNode = new Node<T>(l, value, null);
        last = newNode;
        if (l == null) {
            first = newNode;
        } else {
            l.next = newNode;

        }
        size++;
        modCount++;
    }

    public T get(int index) {
        Objects.checkIndex(index, size);
        Node<T> x = null;
       if (index >= 0 && index < size) {
            if (index < (size >> 1)) {
                x = first;
                for (int i = 0; i < index; i++) {
                   x = x.next;
                }
            } else {
                x = last;
                for (int i = size - 1; i > index; i--) {
                    x = x.prev;
                }
            }
        }
        return (T) x.item;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private int count = 0;
            private int expectedModCount = modCount;
            private Node<T> actual = first;
            @Override
            public boolean hasNext() {
                if (modCount != expectedModCount) {
                    throw new ConcurrentModificationException();
                }
                return count < size;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                T rsl = actual.item;
                actual = actual.next;
                count++;
                return  rsl;
            }
        };
    }
}
