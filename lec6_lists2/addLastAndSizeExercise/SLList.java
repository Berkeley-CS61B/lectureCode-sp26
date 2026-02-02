package lec4_lists2.addLastAndSizeExercise;

public class SLList {
    private class IntNode {
        public int item;    // first number in the list
        public IntNode next; // rest of the list

        public IntNode(int i, IntNode n) {
            item = i;
            next = n;
        }
    }
    private IntNode first;

    public SLList(int x) {
        first = new IntNode(x, null);
    }

    public void addFirst(int x) {
        first = new IntNode(x, first);
    }

    public int getFirst() {
        return first.item;
    }

    // TODO: Add an addLast and size method
}
