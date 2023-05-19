package ru.clevertec.clevertec_final.cache.impl.lruCache;

import ru.clevertec.clevertec_final.cache.impl.lruCache.node.DummyLinkedListNode;
import ru.clevertec.clevertec_final.cache.impl.lruCache.node.LinkedListNodeImpl;
import ru.clevertec.clevertec_final.cache.impl.lruCache.node.api.LinkedListNode;

import java.util.Collection;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Implementation of a Doubly Linked List data structure.
 *
 * @param <T> the type of elements stored in the linked list
 */
public class DoublyLinkedList<T> {

    private DummyLinkedListNode<T> dummyNode;
    private LinkedListNode<T> head;
    private LinkedListNode<T> tail;
    private AtomicInteger size;
    private ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

    /**
     * Constructs a new DoublyLinkedList instance.
     */
    public DoublyLinkedList() {
        this.dummyNode = new DummyLinkedListNode<T>(this);
        clear();
    }

    /**
     * Clears the linked list by resetting the head, tail, and size.
     */
    public void clear() {
        this.lock.writeLock().lock();
        try {
            head = dummyNode;
            tail = dummyNode;
            size = new AtomicInteger(0);
        } finally {
            this.lock.writeLock().unlock();
        }
    }

    /**
     * Returns the number of elements in the linked list.
     *
     * @return the size of the linked list
     */
    public int size() {
        this.lock.readLock().lock();
        try {
            return size.get();
        } finally {
            this.lock.readLock().unlock();
        }
    }

    /**
     * Checks if the linked list is empty.
     *
     * @return true if the linked list is empty, false otherwise
     */
    public boolean isEmpty() {
        this.lock.readLock().lock();
        try {
            return head.isEmpty();
        } finally {
            this.lock.readLock().unlock();
        }
    }

    /**
     * Checks if the linked list contains a specific value.
     *
     * @param value the value to search for
     * @return true if the value is found, false otherwise
     */
    public boolean contains(T value) {
        this.lock.readLock().lock();
        try {
            return search(value).hasElement();
        } finally {
            this.lock.readLock().unlock();
        }
    }

    /**
     * Searches for the first occurrence of a value in the linked list.
     *
     * @param value the value to search for
     * @return the node containing the value, or a dummy node if the value is not found
     */
    public LinkedListNode<T> search(T value) {
        this.lock.readLock().lock();
        try {
            return head.search(value);
        } finally {
            this.lock.readLock().unlock();
        }
    }

    /**
     * Adds a value to the front of the linked list.
     *
     * @param value the value to add
     * @return the new head node
     */
    public LinkedListNode<T> add(T value) {
        this.lock.writeLock().lock();
        try {
            head = new LinkedListNodeImpl<T>(value, head, this);
            if (tail.isEmpty()) {
                tail = head;
            }
            size.incrementAndGet();
            return head;
        } finally {
            this.lock.writeLock().unlock();
        }
    }

    /**
     * Adds multiple values to the front of the linked list.
     *
     * @param values the collection of values to add
     * @return true if all values are successfully added, false if any value fails to add
     */
    public boolean addAll(Collection<T> values) {
        this.lock.writeLock().lock();
        try {
            for (T value : values) {
                if (add(value).isEmpty()) {
                    return false;
                }
            }
            return true;
        } finally {
            this.lock.writeLock().unlock();
        }
    }

    /**
     * Removes the first occurrence of a value from the linked list.
     *
     * @param value the value to remove
     * @return the removed node, or a dummy node if the value is not found
     */
    public LinkedListNode<T> remove(T value) {
        this.lock.writeLock().lock();
        try {
            LinkedListNode<T> linkedListNode = head.search(value);
            if (!linkedListNode.isEmpty()) {
                if (linkedListNode == tail) {
                    tail = tail.getPrev();
                }
                if (linkedListNode == head) {
                    head = head.getNext();
                }
                linkedListNode.detach();
                size.decrementAndGet();
            }
            return linkedListNode;
        } finally {
            this.lock.writeLock().unlock();
        }
    }

    /**
     * Removes the tail node from the linked list.
     *
     * @return the removed tail node
     */
    public LinkedListNode<T> removeTail() {
        this.lock.writeLock().lock();
        try {
            LinkedListNode<T> oldTail = tail;
            if (oldTail == head) {
                tail = head = dummyNode;
            } else {
                tail = tail.getPrev();
                oldTail.detach();
            }
            if (!oldTail.isEmpty()) {
                size.decrementAndGet();
            }
            return oldTail;
        } finally {
            this.lock.writeLock().unlock();
        }
    }

    /**
     * Moves a node to the front of the linked list.
     *
     * @param node the node to move to the front
     * @return the moved node if it is not empty, or the dummy node otherwise
     */
    public LinkedListNode<T> moveToFront(LinkedListNode<T> node) {
        return node.isEmpty() ? dummyNode : updateAndMoveToFront(node, node.getElement());
    }

    /**
     * Updates the value of a node and moves it to the front of the linked list.
     *
     * @param node     the node to update and move to the front
     * @param newValue the new value for the node
     * @return the moved node if it is not empty, or the dummy node otherwise
     */
    public LinkedListNode<T> updateAndMoveToFront(LinkedListNode<T> node, T newValue) {
        this.lock.writeLock().lock();
        try {
            if (node.isEmpty() || (this != (node.getListReference()))) {
                return dummyNode;
            }
            detach(node);
            add(newValue);
            return head;
        } finally {
            this.lock.writeLock().unlock();
        }
    }

    private void detach(LinkedListNode<T> node) {
        if (node != tail) {
            node.detach();
            if (node == head) {
                head = head.getNext();
            }
            size.decrementAndGet();
        } else {
            removeTail();
        }
    }
}

