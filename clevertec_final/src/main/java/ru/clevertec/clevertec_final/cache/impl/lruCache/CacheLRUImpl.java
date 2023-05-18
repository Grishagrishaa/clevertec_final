package ru.clevertec.clevertec_final.cache.impl.lruCache;


import ru.clevertec.clevertec_final.cache.Cache;
import ru.clevertec.clevertec_final.cache.impl.lruCache.node.CacheElement;
import ru.clevertec.clevertec_final.cache.impl.lruCache.node.api.LinkedListNode;

import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.ReentrantReadWriteLock;



public class CacheLRUImpl<K, V> implements Cache<K, V> {
    private final int size;
    private final Map<K, LinkedListNode<CacheElement<K, V>>> keyMap;
    private final DoublyLinkedList<CacheElement<K, V>> cacheElements;
    private final ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

    public CacheLRUImpl(int size) {
        this.size = size;
        this.keyMap = new ConcurrentHashMap<>(size);
        this.cacheElements = new DoublyLinkedList<>();
    }

    @Override
    public V put(K key, V value) {
        this.lock.writeLock().lock();
        try {
            CacheElement<K, V> item = new CacheElement<K, V>(key, value);
            LinkedListNode<CacheElement<K, V>> newNode;
            if (this.keyMap.containsKey(key)) {
                LinkedListNode<CacheElement<K, V>> node = this.keyMap.get(key);
                newNode = cacheElements.updateAndMoveToFront(node, item);
            } else {
                if (this.size() >= this.size) {
                    this.evictElement();
                }
                newNode = this.cacheElements.add(item);
            }
            if (newNode.isEmpty()) {
                return null;
            }
            this.keyMap.put(key, newNode);
            return value;
        } finally {
            this.lock.writeLock().unlock();
        }
    }

    @Override
    public Optional<V> get(K key) {
        this.lock.readLock().lock();
        try {
            LinkedListNode<CacheElement<K, V>> linkedListNode = this.keyMap.get(key);
            if (linkedListNode != null && !linkedListNode.isEmpty()) {
                keyMap.put(key, this.cacheElements.moveToFront(linkedListNode));
                return Optional.of(linkedListNode.getElement().getValue());
            }
            return Optional.empty();
        } finally {
            this.lock.readLock().unlock();
        }
    }

    @Override
    public void remove(K key) {
        this.lock.writeLock().lock();
        try {
            if (!keyMap.containsKey(key) || cacheElements.size() == 0) return;

            LinkedListNode<CacheElement<K, V>> cacheNode = keyMap.get(key);

            cacheNode.getPrev().setNext(cacheNode.getNext());
            cacheNode.getNext().setPrev(cacheNode.getPrev());

            cacheElements.remove(cacheNode.getElement());
            keyMap.remove(key);
        } finally {
            this.lock.writeLock().unlock();
        }
    }

    public int size() {
        this.lock.readLock().lock();
        try {
            return cacheElements.size();
        } finally {
            this.lock.readLock().unlock();
        }
    }

    public boolean isEmpty() {
        return size() == 0;
    }


    private boolean evictElement() {
        this.lock.writeLock().lock();
        try {
            LinkedListNode<CacheElement<K, V>> linkedListNode = cacheElements.removeTail();
            if (linkedListNode.isEmpty()) {
                return false;
            }
            keyMap.remove(linkedListNode.getElement().getKey());
            return true;
        } finally {
            this.lock.writeLock().unlock();
        }
    }
}
