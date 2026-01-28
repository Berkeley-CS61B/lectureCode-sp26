package lec4_testing;

public class Sort {
    // sorts x in place
    public static void sort(String[] x) {
        sort(x, 0);
    }

    // recursive helper method that sorts x
    // starting from position start
    private static void sort(String[] x, int start) {
        if (start == x.length - 1) {
            return;
        }
        int smallestIndex = findSmallest(x, start);
        swap(x, start, smallestIndex);
        sort(x, start + 1);
    }


    // returns the index of the smallest item
    // that is still active, i.e. at start or later
    public static int findSmallest(String[] x, int start) {
        int smallestIndex = start;
        for (int i = start + 1; i < x.length; i += 1) {
            int cmp = x[i].compareTo(x[smallestIndex]);
            // this apparently means x[i] is smaller
            if (cmp < 0) {
                smallestIndex = i;
            }
        }
        return smallestIndex;
    }

    public static void swap(String[] input, int a, int b) {
        String temp = input[a];
        input[a] = input[b];
        input[b] = temp;
    }
}
