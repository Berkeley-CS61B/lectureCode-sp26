package lec27_hashing2;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class MutableKeysDemo {
    public static void main() {
        List<Integer> items = new ArrayList<>();
        items.add(1);
        items.add(1);
        IO.println(items.hashCode());

        HashSet<List<Integer>> hs = new HashSet<>();
        hs.add(items);
        hs.add(List.of(2, 3));
        IO.println(hs.contains(items));

        items.add(7);
        IO.println(hs.contains(items));
        IO.println(items.hashCode());
    }
}
