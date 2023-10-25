package Task2;

import java.util.NoSuchElementException;

public class SinglyLinkedList<E> {
    private Node<E> head = null;
    private Node<E> tail = null;
    private int size;

    public SinglyLinkedList() {
        super();
    }

    // Returns the number of elements in the list.
    public int size() {
        return size;
    }

    // Returns true if the list is empty, and false otherwise.
    public boolean isEmpty() {
        return size == 0;
    }

    // Returns (but does not remove) the first element in the list.

    public E first() {
        if (isEmpty()) {
            throw new NoSuchElementException("Empty linked list");
        }
        return head.getData();
    }

    // Returns (but does not remove) the last element in  the list.

    public E last() {
        if (isEmpty()) {
            throw new NoSuchElementException("Empty linked list");
        }
        return tail.getData();
    }

    // Adds a new element to the front of the list.
    public void addFirst(E e) {
        Node<E> newNode = new Node<>(e);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.setNext(head);
            head = newNode;
        }
        size++;
    }

    // Adds a new element to the end of the list.
    public void addLast(E e) {
        Node<E> newNode = new Node<>(e);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.setNext(newNode);
            tail = newNode;
        }
        size++;
    }

    // Removes and returns the first element of the list.
    public E removeFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException("Empty linked list");
        }

        E first = head.getData();
        Node<E> previous = head;
        head = head.getNext();
        if (isEmpty()) {
            tail.setNext(null);
        } else {
            previous.setNext(null);
        }
        size--;
        return first;
    }

    // Removes and returns the last element of the list.
    public E removeLast() {
        if (isEmpty()) {
            throw new NoSuchElementException("Empty linked list");
        }
        if (size == 1) {
            removeFirst();
        }

        Node<E> prev = null;
        Node<E> current = head;

        while (current.getNext() != null) {
            prev = current;
            current = current.getNext();
        }

        E data = current.getData();
        tail = prev;
        if (tail != null) {
            tail.setNext(null);
        }
        size--;
        return data;
    }
    public void printNodes() {
        Node<E> currentNode = head;
        while (currentNode != null) {
            if (currentNode.getNext() == null) {
                System.out.print(currentNode.getData());
                break;
            }
            System.out.print(currentNode.getData() + " -> ");
            currentNode = currentNode.getNext();
        }
        System.out.println();
    }
}
