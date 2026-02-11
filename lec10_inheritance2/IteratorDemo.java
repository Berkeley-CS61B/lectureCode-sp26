package lec10_inheritance2;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class IteratorDemo {
    public static void main(String[] args) {
        Set<Integer> javaset = new TreeSet<>();
        javaset.add(5);
        javaset.add(23);
        javaset.add(42);
        for (int i : javaset) {
            System.out.println(i);
        }

        // the code above is EXACTLY THE SAME as:
        Iterator<Integer> seer
                = javaset.iterator();

        while (seer.hasNext()) {
            int x = seer.next();
            System.out.println(x);
        }
    }
}
