package ru.clevertec.clevertec_final.cache.impl.lruCache.node;


/**
 * Represents a cached element.
 */
public class CacheElement<K,V> {
    private K key;
    private V value;

    /**
     * Constructs a new CacheElement object with the specified key, value, and expiration time.
     *
     * @param key           the key of the cached element
     * @param value         the value of the cached element
     */
    public CacheElement(K key, V value) {
        this.value = value;
        this.key = key;
    }
    /**
     * Returns the key of the cached element.
     *
     * @return the key of the cached element
     */
    public K getKey() {
        return key;
    }

    /**
     * Set the key of the cached element.
     *
     */
    public void setKey(K key) {
        this.key = key;
    }

    /**
     * Returns the value of the cached element.
     *
     * @return the value of the cached element
     */
    public V getValue() {
        return value;
    }

    /**
     * Set the value of the cached element.
     *
     */
    public void setValue(V value) {
        this.value = value;
    }
}
