package lec8_lists4;

/**
 * AList before we've made the improvements that we'll make in lecture 8.
 * After lecture, we'll upload the new version of AList with all of the code
 * we wrote during lecture. This version exists in case you'd like to
 * follow along writing code during lecture!
 */
public class AList {
    private int size;
    private int[] items;

    public AList() {
        items = new int[999];
        size = 0;
    }

    /** Adds x to the end of our list. */
    public void addLast(int x) {
        items[size] = x;
        size += 1;
    }

    /** Returns the item at index i. */
    public int get(int i) {
        return items[i];
    }

    public int size() {
        return size;
    }

    /** Removes and returns the last item in the list. */
    public int removeLast() {
        size -= 1;
        return items[size]; // Note that we don't need to zero out this item!
    }

    public static void main(String[] args) {
        AList myList = new AList();
    }
}
