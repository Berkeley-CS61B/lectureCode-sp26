package lec8_lists4;

// AList of integers
// Hug is a type to be picked later
public class AList<Hug> {
    public int size;
    public Hug[] contents;

    public AList() {
        size = 0;
        contents = (Hug[]) new Object[100];
    }

    // replaces the existing array with a new array of
    // requested size
    private void resize(int capacity) {
        Hug[] a = (Hug[]) new Object[capacity];
        for (int i = 0; i < size; i += 1) {
            a[i] = contents[i];
        }
        contents = a;
    }

    // size: 3
    // contents: [6, 3, 9, -, -, -, -, ...]
    public void addLast(Hug x) {
        // I worked out a little example on paper
        // it felt right ot me that it should be
        // contents[size]

        // is the array full
        if (size == contents.length) {
            resize(size + 1);
        }

        contents[size] = x;
        size += 1;
    }

    // size: 3
    // contents: [6, 3, 9, -, -, -, -, ...]
    public Hug getLast() {
        return contents[size - 1];
    }

    public int size() {
        return size;
    }

    // size: 3
    // contents: [6, 3, 9, -, -, -, -, ...]
    public Hug get(int i) {
        if (i >= size) {
            throw new IndexOutOfBoundsException("You dummy too big of index.. mayb ei'm the dumy");
        }
        return contents[i];
    }

    // we're supposed to return the 9
    // size: 3
    // contents: [6, 3, 9, -, -, -, -, ...]
    public Hug removeLast() {
        Hug valueToReturn = getLast();
        // contents[size - 1] = 0; (purist or not, monk decisions)
        size = size - 1;
        return valueToReturn;
    }
}
