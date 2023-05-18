package ru.clevertec.clevertec_final.cache;

import java.util.Optional;

public interface Cache<K, V> {
    V put(K key, V value);

    Optional<V> get(K key);

    void remove(K key);
}
