package ru.job4j.design.сache;

import java.io.IOException;

public interface Cache<K, V> {
    V get(K key) throws Exception;
    void put(K key, V value);
}
