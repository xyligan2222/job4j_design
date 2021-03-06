package ru.job4j.design.collection;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.NoSuchElementException;

public class ForwardLinked<T> implements Iterable<T> {
    private Node<T> head;

    public void add(T value) {
        Node<T> node = new Node<T>(value, null);
        if (head == null) {
            head = node;
            return;
        }
        Node<T> tail = head;
        while (tail.next != null) {
            tail = tail.next;
        }
        tail.next = node;

    }

    public  void deleteFirst() {
        if (head == null) {
            throw new NoSuchElementException();
        }
        head = head.next;
    }

    public void deleteLast() {
        if (head == null) {
            throw new NoSuchElementException();
        }
        Node<T> tail = head;
        if (tail.next == null) {
            head = null;
        } else {
            while (tail.next.next != null) {
                tail = tail.next;
            }
            tail.next = null;
        }
      //  return (T) tail;
    }

    public void revert() {
        Node<T> tmp = head;
        head = null;
        while (tmp != null) {
            Node<T> parent = tmp;
            tmp = tmp.next;
            parent.next = head;
            head = parent;
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            Node<T> node = head;

            @Override
            public boolean hasNext() {
                return node != null;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                T value = node.value;
                node = node.next;
                return value;
            }
        };
    }

    private static class Node<T> {
        T value;
        Node<T> next;

        public Node(T value, Node<T> next) {
            this.value = value;
            this.next = next;
        }
    }
}