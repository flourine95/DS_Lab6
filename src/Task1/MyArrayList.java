package Task1;

import java.util.Arrays;
import java.util.Comparator;

public class MyArrayList<E> {
    public static final int DEFAULT_CAPACITY = 10;
    private E[] elements;
    private int size;

    public MyArrayList() {
        this.elements = (E[]) new Object[DEFAULT_CAPACITY];
    }

    public MyArrayList(int capacity) {
        this.elements = (E[]) new Object[capacity];
    }


    // creates an array of double-size if the array of elements is full
    public void growSize() {
        if (this.elements.length == this.size) {
            E[] newArray = (E[]) new Object[this.elements.length * 2];
            System.arraycopy(this.elements, 0, newArray, 0, this.elements.length);
            this.elements = newArray;
        }
    }

    // Returns the number of elements in this list.
    public int size() {
        return this.size;
    }

    // Returns whether the list is empty.
    public boolean isEmpty() {
        return this.size == 0;
    }

    // Returns (but does not remove) the element at index i.
    public E get(int i) throws IndexOutOfBoundsException {
        if (i < 0 || i >= this.size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        return this.elements[i];
    }


    public E set(int i, E e) throws IndexOutOfBoundsException {
        if (i < 0 || i >= this.size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        E old = this.elements[i];
        this.elements[i] = e;
        return old;
    }

    // It is used to append the specified element at the end of a list.
    public boolean add(E e) {
        growSize();
        this.elements[size++] = e;
        return true;
    }

    // Inserts element e to be at index i, shifting all subsequent elements later.
    public void add(int i, E e) throws IndexOutOfBoundsException {
        if (i < 0 || i > this.size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        growSize();
        System.arraycopy(this.elements, i, this.elements, i + 1, size);
        this.elements[i] = e;
        this.size++;
    }

    // Removes and returns the element at index i, shifting subsequent elements earlier.
    public E remove(int i) throws IndexOutOfBoundsException {
        if (i < 0 || i >= this.size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        E old = this.elements[i];
        System.arraycopy(this.elements, i + 1, this.elements, i, size - i - 1);
        this.size--;
        return old;
    }

    // It is used to clear all elements in the list.
    public void clear() {
        for (int i = 0; i < this.size; i++) {
            this.elements[i] = null;
        }
        this.size = 0;
    }

    // It is used to return the index in this list
    // of the last occurrence of the specified element,
    // or -1 if the list does not contain this element.

    public int lastIndexOf(Object o) {
        for (int i = this.size - 1; i >= 0; i--) {
            if ((o == null && this.elements[i] == null) || (o != null && o.equals(this.elements[i]))) {
                return i;
            }
        }
        return -1;
    }

    // It is used to return an array containing all the
    // elements in this list in the correct order.

    public E[] toArray() {
        E[] arrayNew = (E[]) new Object[this.size];
        System.arraycopy(this.elements, 0, arrayNew, 0, size);
        return arrayNew;
    }

    // It is used to return a shallow copy of an ArrayList.
    public MyArrayList<E> clone() {
        try {
            MyArrayList<E> clone = (MyArrayList<E>) super.clone();
            clone.elements = elements.clone();
            return clone;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }

    // It returns true if the list contains the specified element
    public boolean contains(E o) {
        for (E e : this.elements) {
            if ((o == null && e == null) || (o != null && o.equals(e))) {
                return true;
            }
        }
        return false;
    }

    // It is used to return the index in this list
    // of the first occurrence of the specified element,
    // or -1 if the List does not contain this element.

    public int indexOf(E o) {
        for (int i = 0; i < this.size; i++) {
            if ((o == null && this.elements[i] == null) || (o != null && o.equals(this.elements[i]))) {
                return i;
            }
        }
        return -1;
    }

    // It is used to remove the first occurrence of the specified element.
    public boolean remove(E e) {
        for (int i = 0; i < this.size; i++) {
            if ((e == null && this.elements[i] == null) || (e != null && e.equals(this.elements[i]))) {
                remove(i);
                return true;
            }
        }
        return false;
    }

    // It is used to sort the elements of the list on the basis of specified comparator.
    public void sort(Comparator<E> c) {
        if (size == 0) {
            return;
        }
        for (int i = 0; i < size - 1; i++) {
            for (int j = i + 1; j < size; j++) {
                if (c.compare(elements[i], elements[j]) > 0) {
                    E temp = elements[i];
                    elements[i] = elements[j];
                    elements[j] = temp;
                }
            }
        }
    }
}
