package ru.job4j.design.collection;




import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;


public class SimpleHashMap<K, V> implements Iterable<SimpleHashMap.Node<K, V>> {
    private Node<K, V>[] array;
    private int capacity = 16;
    private final double loadFactor = 0.71;
    private int modCount;
    private int size;

    public SimpleHashMap() {
        this.array = new Node[capacity];
        this.size = 0;
    }

    public boolean insert(K key, V value) {
        if (size >= capacity * loadFactor) {
            resize();
        }
        size++;
        modCount++;
        return true;
    }

    public V get(K key) {
        int index = findIndex(key);
        if (this.array[index] == null) {
            return null;
        }
        if (hash(key) == hash(array[index].key)
                && (key.equals(array[index].key) || key == array[index].key)) {
            return this.array[index].value;
        }
        return null;
    }

    public boolean delete(K key) {
        int index = findIndex(key);
        boolean rsl = false;
        if (this.array[index] == null) {
            rsl = false;
        }
        if (hash(key) == hash(this.array[index].key)
                && (key.equals(array[index].key) || key == array[index].key)) {
            size--;
            modCount--;
            this.array[index].key = null;
            rsl = true;
        }
        return rsl;
    }


    private void resize() {
        this.capacity = capacity * 2;
        Node<K, V>[] newArray = new Node[capacity];
        int index;
        for (Node<K, V> node : array) {
            if (node != null) {
                index = findIndex(node.getKey());
                newArray[index] = node;
            }
        }
        this.array = newArray;
    }

    static final int hash(Object key) {
        int h = key.hashCode();
        return (key == null) ? 0 : h ^ (h >>> 16);
    }

    private int findIndex(K key) {
        return hash(key) & (capacity - 1);
    }

    @Override
    public Iterator<Node<K, V>> iterator() {
        return new Iterator<Node<K, V>>() {
            private int count = 0;
            private int expectedModCount = modCount;

            @Override
            public boolean hasNext() {
                if (modCount != expectedModCount) {
                    throw new ConcurrentModificationException();
                }

                return count < capacity;
            }

            @Override
            public Node<K, V> next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return array[count++];
            }
        };
    }
    public static class Node<A, B> {
        private A key;
        private B value;

        public A getKey() {
            return key;
        }

        public B getValue() {
            return value;
        }

        public Node(A key, B value) {
            this.key = key;
            this.value = value;
        }
    }
}
