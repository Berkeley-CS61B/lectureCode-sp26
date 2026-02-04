package lec7_lists3;

/** Beautiful class that hides the ugliness within. */
public class SLList<Pizza> {
    private class Node {
        Pizza item;
        Node next;

        public Node(Pizza item, Node next) {
            this.item = item;
            this.next = next;
        }
    }

    /** sentinel always exists! If the list has more than 0 items,
     * the first item will be at sentinel.next.
     */
    private Node sentinel;
    private int size;

    /** Makes an empty list. */
    public SLList() {
        sentinel = new Node(null, null);
        size = 0;
    }

    public SLList(Pizza first) {
        this.sentinel = new Node(null, null);
        sentinel.next = new Node(first, null);
        size = 1;
    }

    /** Adds x to the front of this list. */
    public void addFirst(Pizza x) {
        size += 1;
        sentinel.next = new Node(x, sentinel.next);
    }

    private Pizza get(Node node, int i) {
        if (i == 0) {
            return node.item;
        }
        return get(node.next, i - 1);
    }

    /** Return the int at index i in the list. */
    public Pizza get(int i) {
        return get(sentinel.next, i);
    }

    /** Returns the number of items in the list. */
    public int size() {
        return size;
    }

    /** Adds x to the end of this list. */
    public void addLast(Pizza x) {
        size += 1;

        Node current = sentinel;
        while (current.next != null) {
            current = current.next;
        }
        current.next = new Node(x, null);
    }
}
