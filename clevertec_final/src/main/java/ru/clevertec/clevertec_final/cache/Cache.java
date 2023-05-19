package ru.clevertec.clevertec_final.cache;

import java.util.Optional;

/**
 * A generic cache interface representing a key-value store.
 *
 * @param <K> the type of the cache keys
 * @param <V> the type of the cache values
 */
public interface Cache<K, V> {

    /**
     * Associates the specified value with the specified key in the cache.
     *
     * @param key   the key with which the specified value is to be associated
     * @param value the value to be associated with the specified key
     * @return the previous value associated with the key, or null if there was no mapping for the key
     */
    V put(K key, V value);

    /**
     * Returns the value to which the specified key is mapped, or an empty Optional if the key is not present in the cache.
     *
     * @param key the key whose associated value is to be returned
     * @return an Optional containing the value to which the specified key is mapped, or an empty Optional if the key is not present in the cache
     */
    Optional<V> get(K key);

    /**
     * Removes the mapping for the specified key from the cache if present.
     *
     * @param key the key whose mapping is to be removed from the cache
     */
    void remove(K key);
}

