package lec10_inheritance2;

import java.util.Iterator;

// saying implements Iterable<T>
// is the magic ingredient so that : works properly as in for (int i : aset)
public class ArraySet<T> implements Iterable<T> {
    private T[] items;
    private int size; // the next item to be added will be at position size

    public ArraySet() {
        items = (T[]) new Object[100];
        size = 0;
    }

    /* Returns true if this map contains a mapping for the specified key.
     */
    public boolean contains(T x) {
        for (int i = 0; i < size; i += 1) {
            if (items[i].equals(x)) {
                return true;
            }
        }
        return false;
    }

    /* Associates the specified value with the specified key in this map.
       Throws an IllegalArgumentException if the key is null. */
    public void add(T x) {
        if (x == null) {
            throw new IllegalArgumentException("can't add null");
        }
        if (contains(x)) {
            return;
        }
        items[size] = x;
        size += 1;
    }

    /* Returns the number of key-value mappings in this map. */
    public int size() {
        return size;
    }

    // need to tell java that an ArraySetIterator is an Iterator
    // THIS IS A COOL WIZARD HE'S SUPPOSED TO COOL WIZARD THINGS
    //  specifically: hasNext
    // .         and .next
    private class ArraySetIterator implements Iterator<T>{
        int wizPos;

        ArraySetIterator() {
            wizPos = 0;
        }

        @Override
        public boolean hasNext() {
            // example: size is 3
            // if the wizard is in position 0, 1, or 2, we're good
            return wizPos < size;
        }

        @Override
        // NEXT GIVES THE VALUE THE WIZARD IS AT
        // AND ALSO MOVES THE WIZARD
        public T next() {
            T thingToReturn = items[wizPos];
            wizPos += 1;
            return thingToReturn;
        }
    }

    public Iterator<T> iterator() {
        return new ArraySetIterator();
    }

    @Override
    public String toString() {
        StringBuilder returnString = new StringBuilder("[");
        for (T x : this) {
            returnString.append(x).append(", ");
        }
        returnString.append("]");
        return returnString.toString();
    }

    public boolean equals(ArraySet o) {
        if (o instanceof ArraySet uddaSet) {
            // in this if statement, uddaSet is of type ArraySet
            // and refers to whatever was given to equals as its parameter
            if (size == uddaSet.size()) {
                for (T x : this) {
                    if (!uddaSet.contains(x)) {
                        return false;
                    }
                 }
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        ArraySet<Integer> aset = new ArraySet<>();
        aset.add(5);
        aset.add(23);
        aset.add(42);

        /* won't work yet */
        // JAVA is unhappy right now, because it does not
        // know that ArraySets have an iterator method.
        for (int i : aset) {
            System.out.println(i);
        }

        /*Iterator<Integer> seer = aset.iterator();
        while (seer.hasNext()) {
            System.out.println(seer.next());
        }*/

        System.out.println(aset);
        aset.equals(List.of(1, 2, 3));

    }

    /* Also to do:
    1. Make ArraySet implement the Iterable<T> interface.
    2. Implement a toString method.
    3. Implement an equals() method.
    */
}
