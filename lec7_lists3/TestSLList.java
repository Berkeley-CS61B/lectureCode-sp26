package lec7_lists3;

import org.junit.Test;
import static com.google.common.truth.Truth.assertThat;

public class TestSLList {
    @Test
    public void testSLList() {
        SLList<Integer> myList = new SLList<>();
        myList.addFirst(1);
        myList.addFirst(2);

        assertThat(myList.get(0)).isEqualTo(2);

        SLList<Object> students = new SLList<>();
        students.addFirst("Areli");
        students.addFirst("Jeremy");

        assertThat(students.get(0)).isEqualTo("Jeremy");
    }
}
