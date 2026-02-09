package lec8_inheritance1.stackSpeedTest;

// File: Stack.java

public interface Stack<E> {
    void push(E item);
    E pop();
    E peek();
    boolean isEmpty();
    int size();
}
