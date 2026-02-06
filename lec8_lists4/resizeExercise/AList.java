package lec8_lists4.resizeExercise;

public class AList {
    private int[] items; // Formerly known as listArray
    private int size;

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
}
