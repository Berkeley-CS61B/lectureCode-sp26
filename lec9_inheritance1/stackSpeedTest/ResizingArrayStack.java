package lec8_inheritance1.stackSpeedTest;

import java.util.EmptyStackException;

public class ResizingArrayStack<E> implements Stack<E> {
    private static final int INITIAL_CAPACITY = 100;
    private E[] arr;
    private int size;

    @SuppressWarnings("unchecked")
    public ResizingArrayStack() {
        arr = (E[]) new Object[INITIAL_CAPACITY];
        size = 0;
    }

    @Override
    public void push(E item) {
        if (size == arr.length) {
            resize(2 * arr.length); // double the capacity
        }
        arr[size++] = item;
    }

    @Override
    public E pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        E item = arr[--size];
        arr[size] = null; // to help GC
        // shrink if needed
        if (size > 0 && size == arr.length / 4) {
            resize(arr.length / 2);
        }
        return item;
    }

    @Override
    public E peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return arr[size - 1];
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    @SuppressWarnings("unchecked")
    private void resize(int newCapacity) {
        E[] newArr = (E[]) new Object[newCapacity];
        System.arraycopy(arr, 0, newArr, 0, size);
        arr = newArr;
    }
}
