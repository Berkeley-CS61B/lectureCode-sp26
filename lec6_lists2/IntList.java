package lec6_lists2;

public class IntList {
    int first;
    IntList rest;

    public IntList(int first, IntList rest) {
        this.first = first;
        this.rest = rest;
    }

    /** Return the number of ints in this list. */
    public int size() {
        if (this.rest == null) {
            return 1;
        }
        return this.rest.size() + 1;
    }

    /** Returns the int at index i. */
    public int get(int i) {
        if (i == 0) {
            return this.first;
        }
        return rest.get(i - 1);
    }

    /** Returns the int at index i, using an iterative approach. */
    public int getIterative(int i) {
        IntList current = this;
        while (i > 0) {
            current = current.rest;
            i -= 1;
        }
        return current.first;
    }

    /** Return a new list with the same ints, but incremented by 1. */
    public IntList incrementRecursiveNonDestructive() {
        IntList incremented = new IntList(first + 1, null);
        if (rest != null) {
            incremented.rest = rest.incrementRecursiveNonDestructive();
        }
        return incremented;
    }

    public void print() {
        for (int i = 0; i < size(); i++) {
            if (i > 0) {
                IO.print(" -> ");
            }
            IO.print(get(i));
        }
        IO.println();
    }

    static void main() {
        IntList kaysList = new IntList(5, new IntList(10, new IntList(15, null)));
        kaysList.print(); // 5 -> 10 -> 15

        IntList studentsList = new IntList(6, kaysList.rest);
        studentsList.rest.first = 7;
        studentsList.rest.rest = null;

        IO.print("Students list: ");
        studentsList.print();

        IO.print("Kays list: ");
        kaysList.print();
    }
}
