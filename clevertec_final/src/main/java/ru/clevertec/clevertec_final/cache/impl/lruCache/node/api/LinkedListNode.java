package ru.clevertec.clevertec_final.cache.impl.lruCache.node.api;

import ru.clevertec.clevertec_final.cache.impl.lruCache.DoublyLinkedList;

/**
 * Represents a node in a doubly linked list.
 *
 * @param <V> the type of element stored in the node
 */
public interface LinkedListNode<V> {

    /**
     * Checks if the node has an element.
     *
     * @return {@code true} if the node has an element, {@code false} otherwise
     */
    boolean hasElement();

    /**
     * Checks if the node is empty.
     *
     * @return {@code true} if the node is empty, {@code false} otherwise
     */
    boolean isEmpty();

    /**
     * Returns the element (value) of the node.
     *
     * @return the element of the node
     * @throws NullPointerException if the node is empty and there is no element to return
     */
    V getElement() throws NullPointerException;

    /**
     * Detaches the node from the linked list.
     */
    void detach();

    /**
     * Returns a reference to the linked list the node belongs to.
     *
     * @return the reference to the linked list
     */
    DoublyLinkedList<V> getListReference();

    /**
     * Sets the previous node reference.
     *
     * @param prev the previous node reference
     * @return the updated node with the new previous reference
     */
    LinkedListNode<V> setPrev(LinkedListNode<V> prev);

    /**
     * Sets the next node reference.
     *
     * @param next the next node reference
     * @return the updated node with the new next reference
     */
    LinkedListNode<V> setNext(LinkedListNode<V> next);

    /**
     * Returns the previous node.
     *
     * @return the previous node
     */
    LinkedListNode<V> getPrev();

    /**
     * Returns the next node.
     *
     * @return the next node
     */
    LinkedListNode<V> getNext();

    /**
     * Searches for a node with the specified value and returns it, or {@code null} if not found.
     *
     * @param value the value to search for
     * @return the node with the specified value, or {@code null} if not found
     */
    LinkedListNode<V> search(V value);
}

