package ru.clevertec.clevertec_final.cache.impl.lruCache.node;


import ru.clevertec.clevertec_final.cache.impl.lruCache.DoublyLinkedList;
import ru.clevertec.clevertec_final.cache.impl.lruCache.node.api.LinkedListNode;

/**
 * Implementation of a node in a doubly linked list.
 *
 * @param <T> the type of value stored in the node
 */
public class LinkedListNodeImpl<T> implements LinkedListNode<T> {

    private T value;
    private DoublyLinkedList<T> list;
    private LinkedListNode<T> next;
    private LinkedListNode<T> prev;

    /**
     * Constructs a new LinkedListNodeImpl object with the given value, next node, and reference to the parent list.
     *
     * @param value the value to be stored in the node
     * @param next the next node in the list
     * @param list the parent doubly linked list
     */
    public LinkedListNodeImpl(T value, LinkedListNode<T> next, DoublyLinkedList<T> list) {
        this.value = value;
        this.next = next;
        this.setPrev(next.getPrev());
        this.prev.setNext(this);
        this.next.setPrev(this);
        this.list = list;
    }

    /**
     * Checks if the node contains a valid element.
     *
     * @return true if the node contains an element, false otherwise
     */
    @Override
    public boolean hasElement() {
        return true;
    }

    /**
     * Checks if the node is empty.
     *
     * @return false since the node is not empty
     */
    @Override
    public boolean isEmpty() {
        return false;
    }

    /**
     * Retrieves the value stored in the node.
     *
     * @return the value stored in the node
     */
    public T getElement() {
        return value;
    }

    /**
     * Detaches the node from the linked list by updating the previous and next nodes.
     */
    public void detach() {
        this.prev.setNext(this.getNext());
        this.next.setPrev(this.getPrev());
    }

    /**
     * Retrieves a reference to the parent doubly linked list.
     *
     * @return the parent doubly linked list
     */
    @Override
    public DoublyLinkedList<T> getListReference() {
        return this.list;
    }

    /**
     * Sets the previous node in the linked list.
     *
     * @param prev the previous node
     * @return the current node with the updated previous node
     */
    @Override
    public LinkedListNode<T> setPrev(LinkedListNode<T> prev) {
        this.prev = prev;
        return this;
    }

    /**
     * Sets the next node in the linked list.
     *
     * @param next the next node
     * @return the current node with the updated next node
     */
    @Override
    public LinkedListNode<T> setNext(LinkedListNode<T> next) {
        this.next = next;
        return this;
    }

    /**
     * Retrieves the previous node in the linked list.
     *
     * @return the previous node
     */
    @Override
    public LinkedListNode<T> getPrev() {
        return this.prev;
    }

    /**
     * Retrieves the next node in the linked list.
     *
     * @return the next node
     */
    @Override
    public LinkedListNode<T> getNext() {
        return this.next;
    }

    /**
     * Searches for a node with the specified value in the linked list.
     *
     * @param value the value to search for
     * @return the node containing the value, or null if not found
     */
    @Override
    public LinkedListNode<T> search(T value) {
        return this.getElement() == value ? this : this.getNext().search(value);
    }
}
