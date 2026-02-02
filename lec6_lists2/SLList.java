package lec6_lists2;

/** Beautiful class that hides the ugliness within. */
public class SLList {
    private class IntNode {
        int item;
        IntNode next;

        public IntNode(int item, IntNode next) {
            this.item = item;
            this.next = next;
        }
    }

    /** sentinel always exists! If the list has more than 0 items,
     * the first item will be at sentinel.next.
     */
    private IntNode sentinel;
    private int size;

    /** Makes an empty list. */
    public SLList() {
        sentinel = new IntNode(0, null);
        size = 0;
    }

    public SLList(int first) {
        this.sentinel = new IntNode(0, null);
        sentinel.next = new IntNode(first, null);
        size = 1;
    }

    /** Adds x to the front of this list. */
    public void addFirst(int x) {
        size += 1;
        sentinel.next = new IntNode(x, sentinel.next);
    }

    private static int get(IntNode node, int i) {
        if (i == 0) {
            return node.item;
        }
        return get(node.next, i - 1);
    }

    /** Return the int at index i in the list. */
    public int get(int i) {
        return get(sentinel.next, i);
    }

    /** Returns the number of items in the list. */
    public int size() {
        return size;
    }

    /** Adds x to the end of this list. */
    public void addLast(int x) {
        size += 1;

        IntNode current = sentinel;
        while (current.next != null) {
            current = current.next;
        }
        current.next = new IntNode(x, null);
    }
}
