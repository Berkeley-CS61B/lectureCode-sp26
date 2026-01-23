package lec2_intro2;
// by importing we can avoid typing java.util.List everywhere
import java.util.ArrayList;
import java.util.List;

public class ListDemo {
    void main() {
        List L = new ArrayList();
        L.add(1);
        L.add(2);
        L.add(3);
        IO.println(L);
    }
}
