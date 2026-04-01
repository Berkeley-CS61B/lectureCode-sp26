package lec27_hashing2;
import org.checkerframework.checker.units.qual.C;

import java.util.HashSet;

public class ContainsDemo {
    public static void main(String[] args) {
        // yellkey.com/although
        HashSet<ColoredNumber> hs = new HashSet<>();
        ColoredNumber x = new ColoredNumber(10);
        hs.add(x);

        IO.println(hs.contains(x)); // true???

        ColoredNumber y = new ColoredNumber(10);
        IO.println(hs.contains(y)); // false????

        IO.println(x.equals(y));
    }
}
