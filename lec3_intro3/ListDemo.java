package lec3_intro3;
// by importing we can avoid typing java.util.List everywhere
import java.util.ArrayList;
import java.util.List;

public class ListDemo {
    void main() {
        List<String> L = new ArrayList<>();
        L.add("a");
        L.add("b");
        String x = L.get(0);
    }
}
