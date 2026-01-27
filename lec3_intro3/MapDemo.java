package lec3_intro3;

import java.util.HashMap;
import java.util.Map;

public class MapDemo {
    void main() {
        // Python code:
        // census = {}
        // census["cat"] = 103
        // census["dog"] = 5
        // num_cats = census["cat"]

        Map<String, Integer> census = new HashMap<>();
        census.put("cat", 103);
        census.put("dog", 5);
        int numCats = census.get("cat");
    }
}

